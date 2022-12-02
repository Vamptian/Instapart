package com.Instapart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Instapart.entity.Offer;
import com.Instapart.entity.Part;
import com.Instapart.entity.User;

@Repository // Between the <,> first put the type of object, next the type of the primary			// key
public interface OfferRepo extends JpaRepository<Offer, Integer> {
	
	@Query(value = "select user_id from part where Id = ?1", nativeQuery = true)
	Integer getUserFromOffer(Integer offerId);

	
	
	
}
