package com.supermart.order.service;

import com.supermart.order.dto.*;
import com.supermart.order.model.Order;
import com.supermart.order.model.OrderStatus;
import com.supermart.order.model.PaymentStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

public interface OrderService {
    OrderResponse getOrderById(Integer id);
    List<OrderResponse> getAllOrders();
    OrderResponse getOrderByOrderNumber(String orderNumber);
    List<OrderResponse> getOrdersByCustomer(Integer customerId);
    List<OrderResponse> getOrdersByPaymentStatus(PaymentStatus paymentStatus);
    List<OrderResponse> getOrdersByCreatedDateBetween(LocalDate startDate, LocalDate endDate);
    Set<OrderResponse> getOrdersBySkuCode(String skuCode);
    String createOrder(OrderRequest orderRequest);
    String cancelOrder(String orderNumber);
    String updateOrderStatus(String orderNumber, OrderStatus newStatus);
    String updateOrder(UpdateOrderRequest updateOrderRequest);
    String updatePaymentStatus(UpdatePaymentStatus updatePaymentStatus);
    boolean forceDeleteOrder(Integer id);
    List<String> hasUncompletedOrders(Integer customerId);
    Set<String> isUsedInOrders(List<String> skuCodes);
    OrderStatus checkOrderStatus(String orderNumber);
    String initiateDelivery(String orderNumber);
    String completeOrder(CompleteOrderRequest completeOrderRequest);

}
