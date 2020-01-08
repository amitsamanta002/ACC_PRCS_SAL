package org.amit.learning.analytics.service;

import org.amit.learning.analytics.dao.model.AccountDetails;
import org.amit.learning.analytics.dao.model.Customer;
import org.amit.learning.analytics.dao.model.AccountInfo;
import org.amit.learning.analytics.dao.model.CustomerInfo;
import org.amit.learning.analytics.model.PayeeInformation;
import org.amit.learning.analytics.model.RequestCustomerInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ICustomersService {

    public List<Customer> getCustomerListbyRequest(String city, String state, String postalCode, String country);

    public List<AccountInfo> getCustomerNameandIDFromDB();

    public Customer buildCustomerInformationbyId(int customerNumber);

    public AccountDetails getCustomerAccountInfomationbyId(int customerNumber);

    public PayeeInformation getPayeeInformation(int accountNumber);

    public int addnewCustomer(RequestCustomerInfo requestCustomerInfo);
}
