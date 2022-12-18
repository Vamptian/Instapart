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

	public Offer createPostOffer(Integer userId, Post post, Part part, Offer offer) {
		
		offer.setPart(part);
		offer.setUserid(userId);

		post.getOffers().add(offer);
		
		offer = offerRepo.save(offer);
		post = postService.save(post);
		
		return offer;
	}

	public Offer createPartOffer(Integer userId, Part part, Offer offer) {
		
		try {
			offer.setUserid(userId);
			offer = offerRepo.save(offer);
			
			
						
			} catch (Exception e) {	
				System.out.println(e);
				e.printStackTrace();
			} catch (Error e) {	
			
				System.out.println(e);
			}
			
			return offer;
		}

	public User getUserFromOffer(Offer offer) {
		Integer userId = offer.getUserId();
		User user = userService.getUserById(userId);
		return user;
	}

	public Offer getOfferById(Integer offerId) {
		
		return offerRepo.getOfferById(offerId);
	}

	public void deleteAllWithPart(Part part) {
		Integer partId = part.getId();
		offerRepo.deleteAllWithPart(partId);
		
	}

	public void deleteAllPartOffers(Part part) {
		Integer partId = part.getId();
		offerRepo.deletePartOffers(partId);
	}
	
	
	
	
	
	
	}

