package org.amit.learning.analytics.dao.mapper;

import org.amit.learning.analytics.dao.model.EmailData;
import org.amit.learning.analytics.dao.model.PayeeDetail;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface OrderRepositoryDao {

    public final String updateOrderStatus= "UPDATE orders SET status = #{status}," +
            "updateByUser = #{updateByUser},updateByTimestamp = (SELECT NOW()) WHERE orderNumber = #{orderNumber} ";

    public final String custmerEmailData = " SELECT A.contactLastName,A.contactFirstName,A.email FROM   " +
            " customers A, orders B WHERE A.customerNumber = B.customerNumber " +
            " AND B.orderNumber = #{orderNumber}";

    public final String selectEmailSubject = "SELECT TRIM(cinfig_param) FROM  data_config " +
            "WHERE config_id = 'MLSUBJ' AND active_ind = 'Y' ";

    public final String selectToAccountDetail = "SELECT A.customerLastName,A.customerFirstName,A.addressLine1,A.addressLine2,A.city,A.state,A.postalCode,A.country " +
            " FROM APS.CUST_DETL A, APS.CUST_ACCOUNT B  " +
            " WHERE A.customerNumber = B.customerNumber " +
            "  AND B.accountNumber = #{accountNumber}";
//All query annotation starts from here...


    @Update(updateOrderStatus)
    public int updateOrderStatus(@Param("status") String status,
                                 @Param("orderNumber") int orderNumber,
                                 @Param("updateByUser") String updateByUser);


    @Select(custmerEmailData)
    @Results({
        @Result(property = "emailTo",column = "email"),
        @Result(property = "toaddFname",column = "contactFirstName"),
        @Result(property = "toaddLname",column = "contactLastName")
    })
    public EmailData selectCustmerEmailData(@Param("orderNumber") int oderNumber);


    @Select(selectEmailSubject)
    public String getSelectEmailSubject();

    @Select(selectToAccountDetail)
    public PayeeDetail getPayeeInformationfromDB(@Param("accountNumber") int accountNumber);

}
