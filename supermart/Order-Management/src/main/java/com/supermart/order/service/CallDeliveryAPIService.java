package com.supermart.order.service;

import com.supermart.order.dto.InitiateDeliveryRequest;

public interface CallDeliveryAPIService {
    boolean initiateDeliveryCall(InitiateDeliveryRequest initiateDeliveryRequest);

}
