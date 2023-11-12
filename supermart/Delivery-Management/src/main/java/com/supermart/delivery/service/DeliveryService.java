package com.supermart.delivery.service;

import com.supermart.delivery.dto.*;
import com.supermart.delivery.model.DeliveryStatus;

import java.time.LocalDate;
import java.util.List;

public interface DeliveryService {
    DeliveryResponse getDeliveryById(Integer id);
    DeliveryResponse getDeliveryByOrderNumber(String orderNumber);
    DeliveryResponse getDeliveryByShippingAddress(String shippingAddress);
    List<DeliveryResponse> getDeliveriesByAssignedTo(Integer assignedTo);
    List<DeliveryResponse> findDeliveriesByStatus(DeliveryStatus deliveryStatus);
    List<DeliveryResponse> findDeliveriesByDateRange(LocalDate startDate, LocalDate endDate);
    DeliveryResponse initiateDelivery(InitiateDeliveryRequest initiateDeliveryRequest);
    String updateStatus(UpdateStatusRequest updateStatusRequest);
    String cancelDelivery(String orderNumber);
    String completeDelivery(String orderNumber);
    String changeAssignee(ChangeAssigneeRequest changeAssigneeRequest);
    String updateEstimatedDeliveryDate(UpdateEstimatedDateRequest updateEstimatedDateRequest);

}
