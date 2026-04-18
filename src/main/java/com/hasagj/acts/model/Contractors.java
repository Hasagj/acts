package com.hasagj.acts.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Contractors")
public class Contractors {
    @Id
    private String id;
    private String name;
    private String inn;
    private String address;
    private Banks bank;
    private String account;
}