package com.application.db.mappers;

import com.application.models.Screening;
import com.application.models.ScreeningExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScreeningMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(ScreeningExample example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(ScreeningExample example);

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
    List<Screening> selectByExample(ScreeningExample example);

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
    int updateByExampleSelective(@Param("record") Screening record, @Param("example") ScreeningExample example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") Screening record, @Param("example") ScreeningExample example);

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