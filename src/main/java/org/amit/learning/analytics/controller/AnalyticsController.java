package org.amit.learning.analytics.controller;


import org.amit.learning.analytics.dao.mapper.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AnalyticsController {

    private static final Logger logger = LoggerFactory.getLogger(AnalyticsController.class);

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private OrderRepository orderRepository;


    @RequestMapping("/inventory/order/updstatus")
    private int UpdateOrderStatus(@RequestParam("orderNumber") int orderNumber,
                                  @RequestParam("orderStatus") String orderStatus,
                                  @RequestHeader("user") String userName){

        if(orderNumber != 0 && !orderStatus.isEmpty()){
            logger.info("Update status request came from user - "+userName);
            return orderRepository.updateOrderStatus(orderStatus,orderNumber,userName);
        }


        return 000000;
    }
}
