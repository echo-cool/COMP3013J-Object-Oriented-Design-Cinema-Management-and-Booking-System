package com.application.db.mappers;

import com.application.models.Screening;
import com.application.models.ScreeningSqlBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScreeningMapper {
    /**
    * countBySQL
    * @param example example
    * @return long long
    */
    long countBySQL(ScreeningSqlBuilder example);

    /**
    * deleteBySQL
    * @param example example
    * @return int int
    */
    int deleteBySQL(ScreeningSqlBuilder example);

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
    int insert(Screening record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(Screening record);

    /**
    * selectBySQL
    * @param example example
    * @return List<Screening> List<Screening>
    */
    List<Screening> selectBySQL(ScreeningSqlBuilder example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Screening Screening
    */
    Screening selectByPrimaryKey(Integer id);

    /**
    * updateBySQLSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQLSelective(@Param("record") Screening record, @Param("example") ScreeningSqlBuilder example);

    /**
    * updateBySQL
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQL(@Param("record") Screening record, @Param("example") ScreeningSqlBuilder example);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(Screening record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(Screening record);
}