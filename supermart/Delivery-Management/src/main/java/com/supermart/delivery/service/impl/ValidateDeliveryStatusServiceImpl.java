package com.supermart.delivery.service.impl;

import com.supermart.delivery.model.DeliveryStatus;
import com.supermart.delivery.service.ValidateDeliveryStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ValidateDeliveryStatusServiceImpl implements ValidateDeliveryStatusService {

    public boolean isStatusUpdateValid(DeliveryStatus currentStatus, DeliveryStatus newStatus) {
        switch (currentStatus) {
            case ASSIGNED:
                return newStatus == DeliveryStatus.IN_PROGRESS || newStatus == DeliveryStatus.CANCELLED;
            case IN_PROGRESS:
                return newStatus == DeliveryStatus.DELIVERED || newStatus == DeliveryStatus.CANCELLED;
            default:
                return false;
        }
    }
}
