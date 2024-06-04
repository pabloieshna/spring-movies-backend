package com.adorno.model;

import org.springframework.data.annotation.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	private String id;
	private String email;
	private String name;
	private String username;
	private String joinedDate;
	private String[] favoriteGenres;
	private String[] favoriteMovies;
	private String bio;
	private String profileImg;
	private boolean isActive;
	private String[] roles;
}
