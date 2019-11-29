package org.amit.learning.analytics.service;

import org.amit.learning.analytics.dao.model.Customer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomersService {

    public List<Customer> getCustomerListbyRequest(String city, String state, String postalCode, String country);

}
