package com.hasagj.acts.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Units")
public class Units {
    @Id
    private String id;
    private String shortName;
    private String fullName;
}