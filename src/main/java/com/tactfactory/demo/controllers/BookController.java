package com.tactfactory.demo.controllers;


import java.io.IOException;
import java.util.Optional;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.tactfactory.demo.dtos.BookDto;
import com.tactfactory.demo.entities.Book;
import com.tactfactory.demo.entities.User;
import com.tactfactory.demo.services.BookService;
import com.tactfactory.demo.services.UserService;

@Controller
@RequestMapping(BookController.BASE_ROUTE)
public class BookController extends BaseCrudController<Book, BookDto>{
	
	@Autowired
    private UserService userService;
	@Autowired
	private BookService service;
	

	public static final String TEMPLATE_NAME = "book";
    public static final String BASE_ROUTE = "book";
	
	public BookController() {
		super(TEMPLATE_NAME);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	@Override
	public String details(@PathVariable final Long id, final Model model) {
		// TODO Auto-generated method stub
		
		System.out.println(id);
		
		Optional<Book> book = service.findById(id);
		
		Book myBook = book.get();
		
		
		
		model.addAttribute("users",userService.getUserListBook(myBook));

		
		return super.details(id, model);
	}
	
	@Override
	protected Book preCreatePost(BookDto dto, HttpServletRequest request) throws Exception {
		
		Book book = new Book();
		
		book.setName(dto.getName());
		book.setNbPage(dto.getNbPage());
		book.setPrice(dto.getPrice());
		
		
		
		if (request.getCookies() != null) {
            for (Cookie cookie : request.getCookies()) {
                if (cookie.getName().equals("idUser")) {
                	Optional<User> user = userService.findById(Long.parseLong(cookie.getValue()));
            		
            		User myUser = user.get();
            		
            		
            		
            		service.linkBookToUser(book, myUser);
                }
            }
        }	
		
		return super.preCreatePost(dto, request);
	}
	
	
	@GetMapping("buy/{idBook}/{idUser}")
	protected void buyAbook(@CookieValue(value= "idUser", defaultValue = "0") String strIdUser, @PathVariable final Long idBook, @PathVariable final Long idUser, final HttpServletResponse response, HttpServletRequest request) throws IOException {
		
		Book book = service.findById(idBook).get();
		
		User seller = userService.findById(idUser).get();
		

		User customer = userService.findById(Long.parseLong(strIdUser)).get();
		
		System.out.println("Controller");
		
		service.buyAbook(book, customer, seller);
		

		
		response.sendRedirect("/book/index");
		
	}
	
	
	@SuppressWarnings("static-access")
	@PostMapping("search")
	protected String searchByName(final Model model, @RequestParam("inputName") String name, @RequestParam("inputnbPageMin") String nbPageMin, @RequestParam("inputnbPageMax") String nbPageMax , @RequestParam("inputPriceMin") String priceMin , @RequestParam("inputPriceMax") String priceMax) {
		
		
		
		int myNbPageMin = nbPageMin != "" ? Integer.parseInt(nbPageMin)  : 0;
		int myNbPageMax = nbPageMax != "" ? Integer.parseInt(nbPageMax)  : Integer.MAX_VALUE;
		
		Float myPriceMin = priceMin != "" ? Float.parseFloat(priceMin)  : 0F;
		Float myPriceMax = priceMax != "" ? Float.parseFloat(priceMax)  : Float.MAX_VALUE;
		
		
		model.addAttribute("items", service.search(name, myNbPageMin, myNbPageMax, myPriceMin, myPriceMax));

		
		
		return "/" + this.TEMPLATE_NAME + "/index";
		
	}


}


