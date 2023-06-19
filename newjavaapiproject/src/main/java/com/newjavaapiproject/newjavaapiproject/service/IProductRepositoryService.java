package com.newjavaapiproject.newjavaapiproject.service;

import java.util.List;

import com.newjavaapiproject.newjavaapiproject.enums.Language;
import com.newjavaapiproject.newjavaapiproject.repository.entity.Product;
import com.newjavaapiproject.newjavaapiproject.request.ProductCreateRequest;
import com.newjavaapiproject.newjavaapiproject.request.ProductUpdateRequest;

//servis metotları tanımlanacak 

public interface IProductRepositoryService {

    // yeni bir ürün oluşturma

    Product createProduct(Language language, ProductCreateRequest productCreateRequest);

    Product getProduct(Language language, Long productId);

    List<Product> getProducts(Language language);

    Product updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest);

    Product delete(Language language, Long productId);

}
