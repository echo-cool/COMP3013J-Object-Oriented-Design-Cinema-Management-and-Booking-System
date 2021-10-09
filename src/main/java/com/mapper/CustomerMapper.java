package com.mapper;

import com.model.Customer;
import com.model.CustomerExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CustomerMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(CustomerExample example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(CustomerExample example);

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
    * selectByExample
    * @param example example
    * @return List<Customer> List<Customer>
    */
    List<Customer> selectByExample(CustomerExample example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Customer Customer
    */
    Customer selectByPrimaryKey(Integer id);

    /**
    * updateByExampleSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExampleSelective(@Param("record") Customer record, @Param("example") CustomerExample example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") Customer record, @Param("example") CustomerExample example);

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