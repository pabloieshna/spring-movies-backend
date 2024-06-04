package com.adorno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "reviews")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Review {

	@Id
    private String id;
	
    private String user; // Referencia al usuario

	@DBRef
	private Movie movie; // Referencia a la película

    private int rating;
    private String comment;
}
