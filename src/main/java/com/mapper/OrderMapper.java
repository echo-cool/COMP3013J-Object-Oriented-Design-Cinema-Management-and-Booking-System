package com.mapper;

import com.model.Order;

public interface OrderMapper {
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
    * selectByPrimaryKey
    * @param id id
    * @return Order Order
    */
    Order selectByPrimaryKey(Integer id);

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