package com.supermart.order.service;

import com.supermart.order.dto.OrderItemRequest;
import com.supermart.order.dto.UseMultipleResponse;
import reactor.core.publisher.Mono;

import java.util.List;

public interface CallInventoryAPIService {
    Mono<UseMultipleResponse> requestOrderItems(List<OrderItemRequest> orderItemRequests);
    boolean restockOrderItems(List<OrderItemRequest> orderItemRequests);
}
