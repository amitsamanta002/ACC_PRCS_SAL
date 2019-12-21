package org.amit.learning.analytics.dao.mapper;

import org.amit.learning.analytics.dao.model.Customer;
import org.amit.learning.analytics.dao.model.AccountInfo;
import org.amit.learning.analytics.dao.model.CustomerInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface CustomerRepositoryDao {

    public String customerDetails = "select customerNumber,customerLastName,customerFirstName " +
            ",phone,addressLine1,addressLine2,city " +
            ",state,postalCode,country, " +
            "email from CUST_DETL  ";

    public String customerSearch = "select customerNumber,CONCAT(customerFirstName, ' ', customerLastName) " +
            "as customerName from CUST_DETL";

    public String customerbyId = "SELECT customerNumber,customerLastName, customerFirstName,phone,addressLine1,addressLine2,city " +
            ",state,postalCode,country," +
            "email from CUST_DETL where customerNumber = #{customerNumber} ";

    public String insertCustomer =  " INSERT INTO APS.CUST_DETL(customerLastName,customerFirstName,phone,addressLine1," +
            "                         addressLine2,city,state,postalCode,country,email) VALUES " +
            "                       ( #{customerLastName},#{customerFirstName},#{phone},#{addressLine1},#{addressLine2},#{city},#{state}, " +
            "                         #{postalCode},#{country},#{email})";

    @Select(customerDetails)
    public List<Customer> getAllCustomerDetails();

    @Select(customerSearch)
     @Results({
             @Result(column = "customerName",property = "customerName"),
             @Result(column = "customerNumber",property = "customerNumber")
     })
    public List<AccountInfo> getAllCustomerNameandID();


    @Select(customerbyId)
    public Customer getCustomerDetailsById(@Param("customerNumber") int customerNumber);

    @Insert(insertCustomer)
    @Options(useGeneratedKeys = false)
    public int addCustomer(CustomerInfo customerInfo);


}
