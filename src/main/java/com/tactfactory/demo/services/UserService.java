package com.tactfactory.demo.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tactfactory.demo.entities.Book;
import com.tactfactory.demo.entities.Role;
import com.tactfactory.demo.entities.User;
import com.tactfactory.demo.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;


	public List<User> findAll() {
		return this.repository.findAll();
	}

//	public void save(User user) {
//		this.repository.save(user);
//	}

	public void generateUsers(final Integer nb, List<Role> listRole) {
		
		
		Random rand = new Random();
		
		if(this.findAll().isEmpty()) {
			for (int i = 0; i < nb; i++) {
				
				User user = new User();
				
				user.setFirstname("fname"+i);
				user.setLastname("Lname"+i);
				
				Role role = listRole.get(rand.nextInt(listRole.size()));
				user.setRole(role);
				
				
				
				this.repository.save(user);
			}
		}
	
	}
	
	public ArrayList<User> getSeller(){
		
		ArrayList<User> users = new ArrayList<User>();
		
		
		
		for (User user : this.findAll()) {
			if(user.getRole().getName() == "Seller") {
				users.add(user);
			}
        }
		
		return users;
		
	}
	
	public List<User> getUserListBook(Book book){
        List<User> result = new ArrayList<User>();
        


        for (User user : this.getSeller()) {
        	
        	for (Book myBook : user.getBooks()) {
        		
        		if (myBook.getName().equals(book.getName()) && myBook.getNbPage() == book.getNbPage() && myBook.getPrice().equals(book .getPrice())) {
					
        			System.out.println("Good");
        			result.add(user);
        			
				}
				
			}
            
        }

        return result;
    }
	
	public Optional<User> findById(Long id) {
        return this.repository.findById(id);
    }
	
	
}
