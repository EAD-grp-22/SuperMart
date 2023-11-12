package com.supermart.inventorymanagement.service;

import com.supermart.inventorymanagement.dto.InventoryResponse;
import com.supermart.inventorymanagement.dto.UseMultipleResponse;
import com.supermart.inventorymanagement.model.Inventory;

import java.util.List;

public interface InventoryMapperService {
    InventoryResponse mapToInventoryResponse(Inventory inventory, Double price);
    Inventory mapToInventory(InventoryResponse inventoryResponse);
    UseMultipleResponse mapToUseMultipleResponse(List<InventoryResponse> inventories, Double totalPrice);
}
