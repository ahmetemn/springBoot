package com.newjavaapiproject.newjavaapiproject.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.newjavaapiproject.newjavaapiproject.enums.Language;
import com.newjavaapiproject.newjavaapiproject.exception.enums.FriendlyMessageCodes;
import com.newjavaapiproject.newjavaapiproject.exception.exceptions.ProductNotCreatedException;
import com.newjavaapiproject.newjavaapiproject.repository.ProductRepository;
import com.newjavaapiproject.newjavaapiproject.repository.entity.Product;
import com.newjavaapiproject.newjavaapiproject.request.ProductCreateRequest;
import com.newjavaapiproject.newjavaapiproject.request.ProductUpdateRequest;
import com.newjavaapiproject.newjavaapiproject.service.IProductRepositoryService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

//bunu log eklemek için kullanırız 

@Slf4j
@Service // busines logic lerin belli olduğunu belirtmek için
@RequiredArgsConstructor
public class ProductRepositoryInt implements IProductRepositoryService {

    private final ProductRepository productRepository; // "final" anahtar kelimesi, bir değişkenin değerinin
                                                       // değiştirilemez olduğunu ve bir kez atandıktan sonra tekrar
                                                       // atanamayacağını belirtmek için kullanılır.

    @Override
    public Product createProduct(Language language, ProductCreateRequest productCreateRequest) {

        log.debug("[{}][createProduct] -> request:{}", this.getClass().getSimpleName(), productCreateRequest);
        try {
            Product product = Product.builder()
                    .productName(productCreateRequest.getProductName())
                    .quantity(productCreateRequest.getQuantitiy())
                    .price(productCreateRequest.getPrice())
                    .deleted(false)
                    .build();
            Product productResponse = productRepository.save(product);
            log.debug("[{}][createProduct] -> response:{}", this.getClass().getSimpleName(), productResponse);
            return productResponse;
        } catch (Exception exception) {
            throw new ProductNotCreatedException(language, FriendlyMessageCodes.PRODUCT_NOT_CREATED_EXCEPTİON,"product request : " + productCreateRequest.toString());
                
        }

       
    }

    @Override
    public Product getProduct(Language language, Long productId) {

        throw new UnsupportedOperationException("Unimplemented method 'getProduct'");
    }

    @Override
    public List<Product> getProducts(Language language) {

        throw new UnsupportedOperationException("Unimplemented method 'getProducts'");
    }

    @Override
    public Product updateProduct(Language language, Long productId, ProductUpdateRequest productUpdateRequest) {

        throw new UnsupportedOperationException("Unimplemented method 'updateProduct'");
    }

    @Override
    public Product delete(Language language, Long productId) {

        throw new UnsupportedOperationException("Unimplemented method 'delete'");
    }

}
