package com.Instapart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.Instapart.entity.Offer;
import com.Instapart.entity.Part;
import com.Instapart.entity.User;

@Repository // Between the <,> first put the type of object, next the type of the primary			// key
public interface OfferRepo extends JpaRepository<Offer, Integer> {
	
	@Query(value = "select user_id from offer where Id = ?1", nativeQuery = true)
	Integer getUserFromOffer(Integer offerId);

	
	@Query(value = "select * from offer where Id = ?1", nativeQuery = true)
	Offer getOfferById(Integer offerId);

	@Query(value = "delete * from offer where offer_part_id = ?1", nativeQuery = true)
	void deleteAllWithPart(Integer partId);
	
	@Modifying
	@Transactional
	@Query(value = "delete from offer where part_id = ?1", nativeQuery = true)
	void deletePartOffers(Integer partId);

	
	
	
}
