package com.supermart.inventorymanagement.service;

import com.supermart.inventorymanagement.dto.CreateProductRequest;
import com.supermart.inventorymanagement.dto.ProductResponse;
import com.supermart.inventorymanagement.dto.UpdateProductRequest;
import com.supermart.inventorymanagement.model.Product;

import java.util.List;

public interface ProductService {
    String addProduct(CreateProductRequest createProductRequest);
    List<ProductResponse> getAllProducts();
    ProductResponse getProductById(String id);
    List<ProductResponse> getProductByName(String name);
    List<ProductResponse> getProductsByBrand(String brand);
    List<ProductResponse> getProductsByCategory(String category);
    List<ProductResponse> getProductsByPriceRange(double minPrice, double maxPrice);
    List<ProductResponse> getProductsByCategoryAndPriceRange(String category, double minPrice, double maxPrice);
    ProductResponse getProductBySkuCode(String skuCode);
    Product updateProduct(UpdateProductRequest updateProductRequest);
    String deleteProduct(String id);

}
