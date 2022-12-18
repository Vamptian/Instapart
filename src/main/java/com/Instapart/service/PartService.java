package com.Instapart.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Instapart.entity.Offer;
import com.Instapart.entity.Part;
import com.Instapart.entity.User;
import com.Instapart.repo.PartRepo;

@Service
public class PartService {

	@Autowired
	PartRepo partRepo;

	@Autowired
	UserService userService;

	public User createPart(Part part, Integer userId) throws Exception {

		try {
			User user = userService.getUserById(userId);
			partRepo.save(part);
			user.getParts().add(part);
			userService.save(user);

			return user;

		} catch (Exception e) {
			throw new Exception("Could not create part");
		}
	}

	public Part getPartById(Integer partId) {

		return partRepo.getPartById(partId);

	}
//
	public List<Part> getAllParts(Integer userId) {
		System.out.println("here");
		if(userId == null) {
			return partRepo.getAvailablePartsNotLoggedIn();
		}
		else {
			return partRepo.getAvailableParts(userId);
			}
	}
	
//	public User getUserFromPart(Part part) {
//		User user = partRepo.getUserFromPart(part);
//		return user
//	}

	public void deletePart(Integer partId) throws Exception {
		Part part = getPartById(partId);
		if(part == null){
			throw new Exception("Cannot find part with that id");
		
		}else {
			partRepo.delete(part);
			
			
		}
	
	}

	public Part save(Part part) {
		part = partRepo.save(part);
		return part;

}

	public void savePart(Part part, Offer offer) {
		try {
			part.getOffers().add(offer);
			save(part);
		} catch(Exception e) {
			System.out.println(e);
		} catch(Error e) {
			System.out.println(e);
		}
	}
}
