package com.Instapart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instapart.entity.Part;
import com.Instapart.entity.Post;
import com.Instapart.entity.User;
import com.Instapart.repo.PostRepo;

@Service
public class PostService {

	@Autowired
	PostRepo postRepo;

	@Autowired
	UserService userService;

	public Post getPostById(Integer postId) {

		return postRepo.getPostById(postId);

	}

	public List<Post> getAllpost() {

		return postRepo.findAll();
	}

	public Post save(Post post) {
		post = postRepo.save(post);
		return post;
		
	}
	
	public User createPost(Post post, Integer userId) throws Exception {
		User user = userService.getUserById(userId);
		user.getPosts().add(post);
		postRepo.save(post);
		return userService.save(user);

	}

	public List<Post> getAllPost(Integer userId) throws Exception {
		if (postRepo.findAll() != null) {
			List<Post> allPost = postRepo.getAllPostWhithoutUser(userId);
			return allPost;
		} else {
			throw new Exception("no post availble");
		}
	}

	public List<Post> getUserPost(User user) throws Exception {
		Integer userId = user.getId();
		if (postRepo.getUserPost(userId) != null) {
			List<Post> userPost = postRepo.getUserPost(userId);

			return userPost;
		} else {
			throw new Exception("no post availble");
		}

	}

	public void delete(Post post) {
		postRepo.delete(post);
		
	}

}
