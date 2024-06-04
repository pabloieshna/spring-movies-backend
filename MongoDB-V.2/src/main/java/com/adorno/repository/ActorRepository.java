package com.adorno.repository;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.adorno.model.Actor;

public interface ActorRepository extends MongoRepository<Actor, ObjectId>{

}
