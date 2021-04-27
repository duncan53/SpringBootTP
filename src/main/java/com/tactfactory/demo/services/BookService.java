package com.tactfactory.demo.services;

import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.demo.entities.Book;
import com.tactfactory.demo.entities.User;
import com.tactfactory.demo.repositories.BookRepository;
import com.tactfactory.demo.repositories.UserRepository;


@Service
public class BookService {
	
	@Autowired
	private BookRepository repository;
	
	@Autowired
    private UserRepository userRepository;
	
	public List<Book> findAll() {
		return this.repository.findAll();
	}
	
	public Optional<Book> findById(Long id) {
        return this.repository.findById(id);
    }
	
	public Book generateBooks() {
		
		Random rand = new Random();
		int i = rand.nextInt(400);
		
		Book book = new Book();
		
		book.setName("Livre" + i);
		book.setNbPage(i);
		book.setPrice((float) i);

		return this.repository.save(book);
		
	}
	
	public void linkBookToUser (Book book, User user) {
		
		
		book = this.repository.save(book);
		
		user.addBook(book);
		
		this.userRepository.save(user);
		
	}
	
	public void buyAbook (Book book, User userLink, User userUnlink) {
		
		System.out.println("Service");
		
		
		userUnlink.deleteBook(book);
		
		this.userRepository.save(userUnlink);
		
			
		userLink.addBook(book);
		
		this.userRepository.save(userLink);
		
	}
	
	public List<Book> search(String name, int nbPageMin, int nbPageMax,Float priceMin ,Float priceMax){
		return repository.findByNameLikeAndNbPageBetweenAndPriceBetween("%" + name + "%", nbPageMin, nbPageMax, priceMin, priceMax );
	}
	
	

}
