//see https://www.mongodb.com/docs/manual/reference/operator/query/regex/

package com.do55anto5.workshopmongo.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.do55anto5.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {
	
	@Query("{ 'title' : { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String text);
	
	List<Post> findByTitleContainingIgnoreCase(String text);

}
