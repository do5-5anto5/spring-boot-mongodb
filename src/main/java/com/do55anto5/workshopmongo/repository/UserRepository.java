package com.do55anto5.workshopmongo.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.do55anto5.workshopmongo.domain.User;

public interface UserRepository extends MongoRepository<User, String> {

}
