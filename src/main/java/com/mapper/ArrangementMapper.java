package com.mapper;

import com.model.Arrangement;

public interface ArrangementMapper {
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
    int insert(Arrangement record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(Arrangement record);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Arrangement Arrangement
    */
    Arrangement selectByPrimaryKey(Integer id);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(Arrangement record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(Arrangement record);
}