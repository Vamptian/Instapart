package com.Instapart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Instapart.entity.Contacts;
import com.Instapart.entity.Post;
import com.Instapart.entity.User;

@Repository // Between the <,> first put the type of object, next the type of the primary
			// key
public interface ContactsRepo extends JpaRepository<Contacts, Integer> {

	@Query(value = "select * from contacts where Id = ?1", nativeQuery = true)
	Post getContactById(Integer Id);

	
	@Query(value = "select * from contacts where user_id = ?1 && contact_id = ?2", nativeQuery = true)
	Contacts findByUsers(Integer user1Id, Integer user2Id);
}