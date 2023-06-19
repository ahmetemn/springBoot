package com.newjavaapiproject.newjavaapiproject.request;

import lombok.Data;

@Data
public class ProductCreateRequest {

    /// burada product id işlemini yapcaz çünkü db tarafında hallediclecek
    //zamanlarda otomarik oalrak  ekleneceği için eklemedik ? . 
    private String productName;
    private Integer quantitiy;
    private Double price;

}
