package org.amit.learning.analytics.dao.mapper;

import org.amit.learning.analytics.dao.model.*;
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

    public String accountbyId = "SELECT customerNumber, accountNumber,accountCatgorie,currentBalance,createTimestamp " +
            "FROM APS.CUST_ACCOUNT where customerNumber = #{customerNumber} ";


    public final String payeeinfobyId = "SELECT A.customerLastName,A.customerFirstName,A.addressLine1,A.addressLine2,A.city,A.state,A.postalCode,A.country " +
            " FROM APS.CUST_DETL A, APS.CUST_ACCOUNT B  " +
            "WHERE A.customerNumber = B.customerNumber " +
            "  AND B.accountNumber = #{accountNumber}";

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


    @Select(accountbyId)
    public AccountDetails getAccountDetailsbyID(@Param("customerNumber") int customerNumber);

    @Select(payeeinfobyId)
    public PayeeDetail getPayeeInformationFromDB(@Param("accountNumber") int accountNumber);

}
