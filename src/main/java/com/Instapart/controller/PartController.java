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

import com.Instapart.entity.Part;
import com.Instapart.entity.User;
import com.Instapart.service.PartService;
import com.Instapart.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PartController {

	@Autowired
	PartService partService;
	
	@Autowired
	UserService userService;

	@RequestMapping(value = "/createPart/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createPart(@RequestBody Part part, @PathVariable Integer userId) {

		try {
//				System.out.println(part.toString());
			User user = partService.createPart(part, userId);
			
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@RequestMapping(value = "/getUserParts", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getUserParts(@RequestBody User user){
		
		try {
			
			List<Part> userParts = user.getParts();
			System.out.println(user.toString());

			
		
			return new ResponseEntity<>(userParts, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/getAllParts/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllParts(@PathVariable Integer userId){
		
		try {
			System.out.println("here");
			List<Part> allParts = partService.getAllParts(userId);
			
			System.out.println("next line should return all parts");
			return new ResponseEntity<>(allParts, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println("here e");
			System.out.println(e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@RequestMapping(value = "/transferPart/{userId}/{partId}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> transferPart(@RequestBody User user, @PathVariable Integer userId, @PathVariable Integer partID){
		
		try {
			
			User seller = userService.getUserById(userId);
			Part soldPart = partService.getPartById(partID);
			userService.transferPart(user, seller, soldPart);
			
			return new ResponseEntity<>(user, HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
		
	}
	
	@RequestMapping(value = "/DeletePart/{partId}", method = RequestMethod.GET)

	public ResponseEntity<Object> deletePart(@PathVariable Integer partId){
try {
			
			partService.deletePart(partId);
			
			return new ResponseEntity<>(null,HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	@RequestMapping(value = "/getPartById/{partId}", method = RequestMethod.GET)

	public ResponseEntity<Object> getPartById(@PathVariable Integer partId){
try {
			
			Part part = partService.getPartById(partId);
			
			return new ResponseEntity<>(part,HttpStatus.OK);

		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
}
