package com.mapper;

import com.model.Arrangement;
import com.model.ArrangementExample;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArrangementMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(ArrangementExample example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(ArrangementExample example);

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
    * selectByExample
    * @param example example
    * @return List<Arrangement> List<Arrangement>
    */
    List<Arrangement> selectByExample(ArrangementExample example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Arrangement Arrangement
    */
    Arrangement selectByPrimaryKey(Integer id);

    /**
    * updateByExampleSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExampleSelective(@Param("record") Arrangement record, @Param("example") ArrangementExample example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") Arrangement record, @Param("example") ArrangementExample example);

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