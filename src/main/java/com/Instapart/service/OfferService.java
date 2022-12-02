package com.Instapart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instapart.entity.Offer;
import com.Instapart.entity.Part;
import com.Instapart.entity.Post;
import com.Instapart.entity.User;
import com.Instapart.repo.OfferRepo;
import com.Instapart.repo.PostRepo;

@Service
public class OfferService {
	
	@Autowired
	PartService partService;

	@Autowired
	PostService postService;

	@Autowired
	UserService userService;
	
	@Autowired
	OfferRepo offerRepo;

	public Offer createPostOffer(User user, Post post, Part part, Offer offer) {
		
		try {
		offer.setPart(part);
		offer.setUser(user);
		offer = offerRepo.save(offer);
		
		post.getOffers().add(offer);
		post = postService.save(post);
		
		
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		
		return offer;
	}

	public Offer createPartOffer(User user, Part part, Offer offer) {
		
		try {
			offer.setUser(user);
			offer = offerRepo.save(offer);
			part.getOffers().add(offer);
			part = partService.save(part);
			
						
			} catch (Exception e) {				
				e.printStackTrace();
			}
			
			return offer;
		}

	public User getUserFromOffer(Offer offer) {
		Integer offerId = offer.getId();
		Integer userId = offerRepo.getUserFromOffer(offerId);
		User user = userService.getUserById(userId);
		return user;
	}
	
	
	
	
	
	
	}

