package org.amit.learning.analytics.dao.mapper;

import org.amit.learning.analytics.dao.model.Customer;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface CustomerRepositoryDao {

    public String customerDetails = "SELECT customerNumber,customerName,contactLastName " +
            "contactFirstName,phone,addressLine1,addressLine2,city " +
            ",state,postalCode,country,salesRepEmployeeNumber,creditLimit " +
            "email from customers ";

    @Select(customerDetails)
    public List<Customer> getAllCustomerDetails();

}
