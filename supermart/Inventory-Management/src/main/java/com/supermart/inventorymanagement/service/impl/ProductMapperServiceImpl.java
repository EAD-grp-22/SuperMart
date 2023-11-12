package com.supermart.inventorymanagement.service.impl;

import com.supermart.inventorymanagement.dto.ProductResponse;
import com.supermart.inventorymanagement.model.Product;
import com.supermart.inventorymanagement.service.ProductMapperService;
import org.springframework.stereotype.Service;

@Service
public class ProductMapperServiceImpl implements ProductMapperService {
    public ProductResponse mapToProductResponse(Product product) {
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .price(product.getPrice())
                .brand(product.getBrand())
                .category(product.getCategory())
                .build();
    }


}
