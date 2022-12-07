package com.Instapart.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instapart.entity.Contacts;
import com.Instapart.entity.Offer;
import com.Instapart.entity.Part;
import com.Instapart.entity.Post;
import com.Instapart.entity.User;
import com.Instapart.repo.ContactsRepo;
import com.Instapart.repo.UserRepo;

@Service
public class UserService {

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ContactsRepo contactsRepo;
	

	public User save(User user) throws Exception {

		try {

			
			return userRepo.save(user);
		} catch (Exception e) {
			throw new Exception("Email/Username must be unique");
		}
	}

	public User signIn(User user) throws Exception {

		User foundUser = userRepo.signIn(user.getEmail(), user.getPassword());
		if (foundUser == null) {
			throw new Exception("Incorrect Log-In Info");
		}

		return foundUser;
	}

	public User getUserByEmail(String email) throws Exception {
		User foundUser = userRepo.getUserByEmail(email);

		if (foundUser == null) {
			throw new Exception("No user found.");
		}

		return foundUser;
	}

//	public void updateUser(User user, User loggedInUser) {
//		user.setId(loggedInUser.getId());
//		userRepo.save(user);
//
//	}

	public User getUserById(Integer userId) {

		return userRepo.getUserById(userId);
	}

	public User transferPart(User user, User seller, Part soldPart) throws Exception {
		
		user.getParts().add(soldPart);
		save(user);
		return user;
	}

	public List<User> getAll() {
		
		return userRepo.findAll();
	}

	public User addContact(User user, Integer userId) throws Exception {
		
		Optional<Contacts> contact = contactsRepo.findById(userId);
		if(user.getId() == userId){
			throw new Exception("cant add yourself.");
			}
		for (User userToCheck: user.getContacts()) {
			if(userToCheck.getId() == userId) {
				throw new Exception("you already have this contact");
			}
		}
		user.getContacts().add(getUserById(userId));
		userRepo.save(user);
		return user;
	}

	public User removeContact(User user, Integer user2Id) {
		Integer user1Id = user.getId();
		
		System.out.println(user1Id );
		System.out.println(user2Id);
		Contacts contact = contactsRepo.findByUsers(user1Id, user2Id);
		System.out.println(contact.getId());
		contactsRepo.deleteById(contact.getId());
		return user;
	}

	public User makeTransfer(User user, Part part) throws Exception {
		
		
		user.getParts().add(part);
		user = save(user);
		
		
		return user;
	}

}

