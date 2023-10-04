package com.do55anto5.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.do55anto5.workshopmongo.domain.Post;

public interface PostRepository extends MongoRepository<Post, String> {

}
