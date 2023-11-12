package com.supermart.order.service;

import com.supermart.order.model.OrderStatus;

public interface ValidateOrderStatusService {
    boolean isStatusUpdateValid(OrderStatus currentStatus, OrderStatus newStatus);
}
