package com.tactfactory.demo.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class User extends BaseEntity {

    @Column(nullable = false)
    private String firstname;

    @Column(nullable = false)
    private String lastname;

//    @ManyToMany
//    @ManyToOne // -> @OneToMany
//    @OneToOne
    @ManyToOne
    private Role role;
    
    @OneToMany
    private List<Book> books = new ArrayList<Book>();

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}
	
	public void addBook(Book book) {
		this.books.add(book);
	}
	
	public void deleteBook(Book book) {
		this.books.remove(book);
	}
    
    
}
