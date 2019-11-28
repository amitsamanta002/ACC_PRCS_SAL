package org.amit.learning.analytics.service;

import org.amit.learning.analytics.model.OrderResponse;
import org.springframework.stereotype.Service;

@Service
public interface IOrderProcessingService {

    public OrderResponse updateAndProcessOrderStatus(int OrderNumber, String orderStatus, String user);
}
