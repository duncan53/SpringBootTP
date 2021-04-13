package com.tactfactory.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tactfactory.demo.dtos.BookDto;
import com.tactfactory.demo.entities.Book;
import com.tactfactory.demo.services.BookService;
import com.tactfactory.demo.services.UserService;

@Controller
@RequestMapping()
public class BookController extends BaseCrudController<Book, BookDto>{

	public static final String TEMPLATE_NAME = "book";
    public static final String BASE_ROUTE = "book";
	
	public BookController() {
		super(TEMPLATE_NAME);
		// TODO Auto-generated constructor stub
	}
	
	@SuppressWarnings("unused")
	@Autowired
	private BookService service;
	
	@SuppressWarnings("unused")
	@Autowired
    private UserService userService;
	
	@Override
	protected void preCreateGet(final Model model) {
	}
	
	@Override
	protected Book preCreatePost(BookDto dto) throws Exception {
		

		
		Book book = new Book();
		book.setName(dto.getName());
		book.setNbPage(dto.getNbPage());
		book.setPrice(dto.getPrice());
		
		
		return book;
	}

}
