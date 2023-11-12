package com.supermart.delivery.service;

import com.supermart.delivery.dto.DeliveryResponse;
import com.supermart.delivery.model.Delivery;

import java.util.List;

public interface DeliveryMapperService {
    DeliveryResponse mapToDeliveryResponse(Delivery delivery);
    List<DeliveryResponse> mapToDeliveryResponseList(List<Delivery> deliveryList);

}
