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
import com.Instapart.entity.Offer;
import com.Instapart.entity.Part;
import com.Instapart.entity.Post;
import com.Instapart.entity.User;
import com.Instapart.repo.ContactsRepo;
import com.Instapart.service.OfferService;
import com.Instapart.service.PartService;
import com.Instapart.service.PostService;
import com.Instapart.service.UserService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class OfferController {

	@Autowired
	UserService userService;
	
	@Autowired
	PartService partService;
	
	@Autowired
	PostService postService;
	
	@Autowired
	OfferService offerService;
	
	@RequestMapping(value = "/createPostOffer/{partId}/{postId}/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Object> createPostOffer(@RequestBody Offer offer, @PathVariable Integer partId, @PathVariable Integer postId ,@PathVariable Integer userId){
		try {
			
			User user = userService.getUserById(userId);
			System.out.println(user.toString());
			Post post = postService.getPostById(postId);
			System.out.println(post.toString());
			Part part = partService.getPartById(partId);
			System.out.println(part.toString());
			Offer newoffer = offerService.createPostOffer(user, post, part, offer);
			System.out.println(newoffer.toString());
			return new ResponseEntity<>(post, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/createPartOffer/{partId}/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public  ResponseEntity<Object> createPartOffer(@RequestBody Offer offer, @PathVariable Integer partId, @PathVariable Integer userId){
		try {
			
			User user = userService.getUserById(userId);
			System.out.println(user.toString());
			
			Part part = partService.getPartById(partId);
			System.out.println(part.toString());
			
			Offer newoffer = offerService.createPartOffer(user, part, offer);
			System.out.println(newoffer.toString());
			return new ResponseEntity<>(part, HttpStatus.OK);
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	@RequestMapping(value = "/getUserFromOffer", method = RequestMethod.GET)
	public ResponseEntity<Object> getUserFromOffer(@RequestBody Offer offer){
		
		try {
			
			User user = offerService.getUserFromOffer(offer);
			return new ResponseEntity<>(user, HttpStatus.OK);

		} catch (Exception e) {
			System.out.println(e);
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
