package com.Instapart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.Instapart.entity.Contacts;
import com.Instapart.entity.User;
import com.Instapart.repo.ContactsRepo;
import com.Instapart.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/signUp", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> signUp(@RequestBody User user) {

		try {
			User signedUpUser = userService.save(user);

			return new ResponseEntity<>(signedUpUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/signIn", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> signIn(@RequestBody User user) {

		try {
			User signedUpUser = userService.signIn(user);

			return new ResponseEntity<>(signedUpUser, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/getUserByEmail/{email}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getUserByEmail(@PathVariable String email) {
		try {
			User foundUser = userService.getUserByEmail(email);
			return new ResponseEntity<>(foundUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/getUserContacts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getUserContacts(@RequestBody User user) {
		try {

			List<User> contacts = user.getContacts();

			return new ResponseEntity<>(contacts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/getAllUsers", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getAllContacts() {
		try {

			List<User> contacts = userService.getAll();

			return new ResponseEntity<>(contacts, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(value = "/addContact/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createContact(@RequestBody User user, @PathVariable Integer userId) {
		try {
			System.out.println(user.toString());
			System.out.println(userId);
			User loggedInUser = userService.addContact(user, userId);

			return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/removeContact/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> removeContact(@RequestBody User user, @PathVariable Integer userId) {
		try {
			
			
			
			User loggedInUser = userService.removeContact(user, userId);

			return new ResponseEntity<>(loggedInUser, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
}



