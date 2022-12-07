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
import com.Instapart.entity.Post;
import com.Instapart.entity.User;
import com.Instapart.service.PostService;


@CrossOrigin(origins = "http://localhost:3000")
@RestController
public class PostController {

	@Autowired
	PostService postService;
	
	@RequestMapping(value = "/createPost/{userId}", method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<Object> createPost(@RequestBody Post post, @PathVariable Integer userId) {

		try {

			User user = postService.createPost(post, userId);
			
			return new ResponseEntity<>(user, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(value = "/getAllPost/{userId}", method = RequestMethod.GET)
	public ResponseEntity<Object> getAllPost(@PathVariable Integer userId){
		try {
			
			List<Post> allPost = postService.getAllPost(userId);
			return new ResponseEntity<>(allPost, HttpStatus.CREATED);

			
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(value = "/getUserPost", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getUserPost(@RequestBody User user){
		try {
			
			List<Post> userPost = postService.getUserPost(user);
			return new ResponseEntity<>(userPost, HttpStatus.CREATED);

			
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
	@RequestMapping(value = "/getPostById/{postId}", method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<Object> getUserPost(@PathVariable Integer postId){
		try {
			
			Post userPost = postService.getPostById(postId); 
			return new ResponseEntity<>(userPost, HttpStatus.CREATED);

			
		}catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		} catch (Error e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
	
	
}
