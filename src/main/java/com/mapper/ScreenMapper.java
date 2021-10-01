package com.mapper;

import com.model.Screen;

public interface ScreenMapper {
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
    int insert(Screen record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(Screen record);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Screen Screen
    */
    Screen selectByPrimaryKey(Integer id);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(Screen record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(Screen record);
}