package com.mapper;

import com.model.Customer;

public interface CustomerMapper {
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
    int insert(Customer record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(Customer record);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Customer Customer
    */
    Customer selectByPrimaryKey(Integer id);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(Customer record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(Customer record);
}