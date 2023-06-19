package com.newjavaapiproject.newjavaapiproject.request;

import lombok.Data;

@Data
public class ProductUpdateRequest {
    
    private Long productId;
    private String productName; 
    private Integer quantitiy; 
    private Double price;
}
