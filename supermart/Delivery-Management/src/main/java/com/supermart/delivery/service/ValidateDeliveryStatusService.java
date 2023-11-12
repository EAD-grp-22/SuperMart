package com.supermart.delivery.service;

import com.supermart.delivery.model.DeliveryStatus;

public interface ValidateDeliveryStatusService {
    boolean isStatusUpdateValid(DeliveryStatus currentStatus, DeliveryStatus newStatus);

}
