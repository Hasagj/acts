package com.hasagj.acts.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "Services")
public class Services {
    @Id
    private String id;
    private String name;
    private String price;
    private String unitId;
    private String unitShortName;
}
