package com.supermart.order.service;

import com.supermart.order.dto.OrderItemRequest;
import com.supermart.order.dto.OrderItemResponse;
import com.supermart.order.dto.OrderResponse;
import com.supermart.order.model.Order;
import com.supermart.order.model.OrderItem;

public interface OrderMapperService {
    OrderResponse mapToOrderResponse(Order order);
    OrderItem mapToOrderItem(OrderItemRequest orderItemRequest, Double price);
    OrderItemResponse mapToOrderItemResponse(OrderItem orderItem);
    OrderItemRequest mapToOrderItemRequest(OrderItem orderItem);

}
