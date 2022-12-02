package com.Instapart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Instapart.entity.Part;
import com.Instapart.entity.User;

@Repository // Between the <,> first put the type of object, next the type of the primary			// key
public interface PartRepo extends JpaRepository<Part, Integer> {

	@Query(value = "select * from part where Id = ?1", nativeQuery = true)
	Part getPartById(Integer Id);
//
//	@Query(value = "select * from part where user_id = ?1", nativeQuery = true)
//	List<Part> getUserParts(Integer userId);
//
	@Query(value = "select * from part where is_available = true and user_id != ?1", nativeQuery = true)
	List<Part> getAvailableParts(Integer id);
	
	@Query(value = "select * from part where is_available", nativeQuery = true)
	List<Part> getAvailablePartsNotLoggedIn();
	
	
}

