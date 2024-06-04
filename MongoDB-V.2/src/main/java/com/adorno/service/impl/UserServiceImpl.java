package com.adorno.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.adorno.model.User;
import com.adorno.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Value("${auth.service.url}")
    private String authServiceUrl;
	private final RestTemplate restTemplate;

    public UserServiceImpl(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public User getUserById(String userId) {
        String url = authServiceUrl + "/auth/" + userId;
        return restTemplate.getForObject(url, User.class);
    }

}
