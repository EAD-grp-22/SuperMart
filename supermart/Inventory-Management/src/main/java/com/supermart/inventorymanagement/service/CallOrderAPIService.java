package com.supermart.inventorymanagement.service;

import java.util.List;
import java.util.Set;

public interface CallOrderAPIService {
    Set<String> isProductUsedInOrder(List<String> skuCodes);
    Set<String> isInventoryUsedInOrder(String skuCode);
}
