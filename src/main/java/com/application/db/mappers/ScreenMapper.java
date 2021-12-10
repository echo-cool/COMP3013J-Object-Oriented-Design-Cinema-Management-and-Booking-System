package com.application.db.mappers;

import com.application.db.builders.ScreenSqlBuilder;
import com.application.db.dao.ScreenDAO;
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
    int insert(ScreenDAO record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(ScreenDAO record);

    /**
    * selectBySQL
    * @param example example
    * @return List<Screen> List<Screen>
    */
    List<ScreenDAO> selectBySQL(ScreenSqlBuilder example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Screen Screen
    */
    ScreenDAO selectByPrimaryKey(Integer id);

    /**
    * updateBySQLSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQLSelective(@Param("record") ScreenDAO record, @Param("example") ScreenSqlBuilder example);

    /**
    * updateBySQL
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQL(@Param("record") ScreenDAO record, @Param("example") ScreenSqlBuilder example);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(ScreenDAO record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(ScreenDAO record);
}