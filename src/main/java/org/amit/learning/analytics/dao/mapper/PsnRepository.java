package org.amit.learning.analytics.dao.mapper;

import org.amit.learning.analytics.dao.model.PsnInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface PsnRepository {

    public final String psnEntrySql = "SELECT ID,ACC_NUM,ACC_HLDR_NME,ACC_HLDR_ADDR " +
            " FROM ANA_PSN_INFO ";

    @Select(psnEntrySql)
    List <PsnInfo> getPsnInfoAll();

}
