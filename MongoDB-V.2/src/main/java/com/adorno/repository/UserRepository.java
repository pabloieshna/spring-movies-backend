package com.adorno.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.User;

public interface UserRepository extends MongoRepository<User, String> {

}
