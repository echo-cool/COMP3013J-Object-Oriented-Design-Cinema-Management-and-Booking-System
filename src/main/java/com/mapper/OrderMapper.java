package com.mapper;

import com.model.Order;
import com.model.OrderExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(OrderExample example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(OrderExample example);

    /**
    * deleteByPrimaryKey
    * @param id id
    * @return int int
    */
    int deleteByPrimaryKey(Integer id);

    /**
    * insert
    * @param record record
    * @return int int
    */
    int insert(Order record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(Order record);

    /**
    * selectByExample
    * @param example example
    * @return List<Order> List<Order>
    */
    List<Order> selectByExample(OrderExample example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Order Order
    */
    Order selectByPrimaryKey(Integer id);

    /**
    * updateByExampleSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExampleSelective(@Param("record") Order record, @Param("example") OrderExample example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") Order record, @Param("example") OrderExample example);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(Order record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(Order record);
}