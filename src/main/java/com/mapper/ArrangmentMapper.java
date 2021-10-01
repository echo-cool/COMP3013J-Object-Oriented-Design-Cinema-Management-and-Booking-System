package com.mapper;

import com.model.Arrangment;

public interface ArrangmentMapper {
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
    int insert(Arrangment record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(Arrangment record);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Arrangment Arrangment
    */
    Arrangment selectByPrimaryKey(Integer id);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(Arrangment record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(Arrangment record);
}