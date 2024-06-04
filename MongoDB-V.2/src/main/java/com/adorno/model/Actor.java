package com.adorno.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Document(collection = "actors")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Actor {
    @Id
    private String id;
    private String name;
    private String birthDate;
    private String birthPlace;
    private String biography;

}
