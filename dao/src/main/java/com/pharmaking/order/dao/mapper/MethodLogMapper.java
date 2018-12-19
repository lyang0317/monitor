package com.pharmaking.order.dao.mapper;


import com.pharmaking.order.common.model.MethodLogDO;
import com.pharmaking.order.common.model.MethodLogExampleDO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MethodLogMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(MethodLogDO record);

    int insertSelective(MethodLogDO record);

    MethodLogDO selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MethodLogDO record);

    int updateByPrimaryKey(MethodLogDO record);
}