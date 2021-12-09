package com.application.db.mappers;

import com.application.models.Screen;
import com.application.models.ScreenSqlBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScreenMapper {
    /**
    * countBySQL
    * @param example example
    * @return long long
    */
    long countBySQL(ScreenSqlBuilder example);

    /**
    * deleteBySQL
    * @param example example
    * @return int int
    */
    int deleteBySQL(ScreenSqlBuilder example);

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
    * selectBySQL
    * @param example example
    * @return List<Screen> List<Screen>
    */
    List<Screen> selectBySQL(ScreenSqlBuilder example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Screen Screen
    */
    Screen selectByPrimaryKey(Integer id);

    /**
    * updateBySQLSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQLSelective(@Param("record") Screen record, @Param("example") ScreenSqlBuilder example);

    /**
    * updateBySQL
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQL(@Param("record") Screen record, @Param("example") ScreenSqlBuilder example);

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