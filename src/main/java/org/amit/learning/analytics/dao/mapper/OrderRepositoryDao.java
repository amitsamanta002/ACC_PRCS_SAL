package org.amit.learning.analytics.dao.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;


@Repository
@Mapper
public interface OrderRepositoryDao {

    public final String updateOrderStatus= "UPDATE orders SET status = #{status}," +
            "updateByUser = #{updateByUser},updateByTimestamp = (SELECT NOW()) WHERE orderNumber = #{orderNumber} ";

    @Update(updateOrderStatus)
    public int updateOrderStatus(@Param("status") String status,
                                 @Param("orderNumber") int orderNumber,
                                 @Param("updateByUser") String updateByUser);

}
