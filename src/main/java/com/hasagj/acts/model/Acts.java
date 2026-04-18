package com.hasagj.acts.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Data
@Document(collection = "Acts")
public class Acts {
    @Id
    private String id;
    private String number;
    private LocalDate date;
    private String contractorId;
    private String contractorName;
    private String clientId;
    private String clientName;
    private List<ActItems> items;
    private Double grandTotal;
}