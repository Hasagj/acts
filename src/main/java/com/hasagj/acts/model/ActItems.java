package com.hasagj.acts.model;

import lombok.Data;

@Data
public class ActItems {
    private String serviceId;
    private String serviceName;
    private Double quantity;
    private String unitShortName;
    private Double price;
    private Double total;
}