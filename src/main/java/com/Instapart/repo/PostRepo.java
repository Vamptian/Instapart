package com.Instapart.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.Instapart.entity.Part;
import com.Instapart.entity.Post;

@Repository // Between the <,> first put the type of object, next the type of the primary
			// key
public interface PostRepo extends JpaRepository<Post, Integer> {

	@Query(value = "select * from post where Id = ?1", nativeQuery = true)
	Post getPostById(Integer Id);

	@Query(value = "select * from post where user_Id = ?1", nativeQuery = true)
	List<Post> getUserPost(Integer userId);
	
}
