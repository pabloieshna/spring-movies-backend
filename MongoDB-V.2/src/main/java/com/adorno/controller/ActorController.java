package com.adorno.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.adorno.model.Actor;
import com.adorno.service.impl.ActorServiceImpl;


@RestController
@RequestMapping("/api/v1/actors")
@CrossOrigin(origins = "http://localhost:4200")
public class ActorController {
	
	@Autowired
	private ActorServiceImpl actorService; 

	@GetMapping
	public ResponseEntity<List<Actor>> getAllActors() {
		return new ResponseEntity<List<Actor>>(actorService.allActors(), HttpStatus.OK);
	}
	
	
}
