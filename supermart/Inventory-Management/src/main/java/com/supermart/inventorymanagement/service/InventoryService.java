package com.supermart.inventorymanagement.service;

import com.supermart.inventorymanagement.dto.CreateInventoryRequest;
import com.supermart.inventorymanagement.dto.InventoryResponse;
import com.supermart.inventorymanagement.dto.UpdateInventoryRequest;
import com.supermart.inventorymanagement.dto.UseMultipleResponse;
import com.supermart.inventorymanagement.model.Inventory;

import java.util.List;
import java.util.Optional;

public interface InventoryService {
    String addInventory(CreateInventoryRequest createInventoryRequest);
    Optional<Inventory> getInventoryBySkuCode(String skuCode);
    List<Inventory> getInventoriesByQuantityRange(int minQuantity, int maxQuantity);
    List<Inventory> getInventoriesByProduct(String productId);
    List<Inventory> getInventoriesByCategory(String category);
    List<Inventory> getInventoriesByBrand(String brand);
    Inventory restockInventory(UpdateInventoryRequest updateInventoryRequest);
    List<Inventory> restockMultipleInventories(List<UpdateInventoryRequest> updateInventoryRequests);
    InventoryResponse useInventory(UpdateInventoryRequest updateInventoryRequest);
    UseMultipleResponse useMultipleInventories(List<UpdateInventoryRequest> updateInventoryRequests);
    String clearInventory(String skuCode);
    boolean isInStock(String skuCode);
}
