package com.adorno.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.adorno.model.Actor;
import com.adorno.repository.ActorRepository;
import com.adorno.service.ActorService;

@Service
public class ActorServiceImpl implements ActorService {
	
	@Autowired
	private ActorRepository actorRepository;

	
	@Override
	public List<Actor> allActors() {
		return actorRepository.findAll();
	}

}
