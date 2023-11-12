package com.supermart.delivery.service;

import com.supermart.delivery.dto.CompleteOrderRequest;

public interface CallOrderAPIService {
    boolean isOrderValid(String orderNumber);
    String initiateCompleteOrder(CompleteOrderRequest completeOrderRequest);

}
