package org.amit.learning.analytics.controller;


import org.amit.learning.analytics.dao.model.Customer;
import org.amit.learning.analytics.service.ICustomersService;
import org.amit.learning.analytics.service.IOrderProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CustmerController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ICustomersService iCustomersService;


    @RequestMapping("/inventory/customers")
    public List<Customer> CustomerDetails(@RequestParam(value = "city",required = false) String city,
                                          @RequestParam(value = "state",required = false)String state,
                                          @RequestParam(value = "postalCode",required = false) String postalCode,
                                          @RequestParam(value = "country",required = false) String country) {

        return  iCustomersService.getCustomerListbyRequest(city,state,postalCode,country);

    }
}
