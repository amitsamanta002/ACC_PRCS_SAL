package org.amit.learning.analytics.controller;


import org.amit.learning.analytics.model.OrderResponse;
import org.amit.learning.analytics.service.IOrderProcessingService;
import org.amit.learning.analytics.mailthread.MailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class OrderController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private IOrderProcessingService iOrderProcessingService;



    @RequestMapping("/inventory/order/updstatus")
    private OrderResponse UpdateOrderStatus(@RequestParam("orderNumber") int orderNumber,
                                  @RequestParam("orderStatus") String orderStatus,
                                  @RequestHeader("user") String userName){

        OrderResponse orderResponse = new OrderResponse();

        if(!userName.isEmpty() && orderNumber!=00 && !orderStatus.isEmpty()){
            orderResponse = iOrderProcessingService.updateAndProcessOrderStatus(orderNumber,orderStatus,userName);
        }
        else{
                logger.info("Input data Error::OrderNumber{},orderStatus{},userName{}",orderNumber,orderStatus,userName);
                orderResponse.setResponseCode(99);
                orderResponse.setResponseStatusCode(9999);
                orderResponse.setResponseMessage("Input data Error");
                orderResponse.setResponseComments("Change the input before calling this endPoint");
        }
        return orderResponse;
  }
}
