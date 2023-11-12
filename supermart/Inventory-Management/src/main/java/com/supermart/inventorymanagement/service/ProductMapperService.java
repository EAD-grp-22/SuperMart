package com.supermart.inventorymanagement.service;

import com.supermart.inventorymanagement.dto.ProductResponse;
import com.supermart.inventorymanagement.model.Product;

public interface ProductMapperService {
    ProductResponse mapToProductResponse(Product product);
}
