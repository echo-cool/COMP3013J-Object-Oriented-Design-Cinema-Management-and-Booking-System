package com.application.db.mappers;

import com.application.models.Screening;
import com.application.models.ScreeningSqlBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScreeningMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(ScreeningSqlBuilder example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(ScreeningSqlBuilder example);

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
    * selectByExample
    * @param example example
    * @return List<Screening> List<Screening>
    */
    List<Screening> selectByExample(ScreeningSqlBuilder example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Screening Screening
    */
    Screening selectByPrimaryKey(Integer id);

    /**
    * updateByExampleSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExampleSelective(@Param("record") Screening record, @Param("example") ScreeningSqlBuilder example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") Screening record, @Param("example") ScreeningSqlBuilder example);

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