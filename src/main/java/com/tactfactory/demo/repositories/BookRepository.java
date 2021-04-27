package com.tactfactory.demo.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tactfactory.demo.entities.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findByNameLikeAndNbPageBetweenAndPriceBetween(String name, int nbPageMin, int nbPageMax, Float priceMin, Float priceMax);
}
