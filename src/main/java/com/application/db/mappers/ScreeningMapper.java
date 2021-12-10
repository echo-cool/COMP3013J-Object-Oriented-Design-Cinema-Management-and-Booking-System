package com.application.db.mappers;

import com.application.db.builders.ScreeningSqlBuilder;
import com.application.db.dao.ScreeningDAO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ScreeningMapper {

    //The Screening mapper
    //SQL statement are in the XML files which can be found in resources folder.

    /**
     * countBySQL
     *
     * @param example example
     * @return long long
     */
    long countBySQL(ScreeningSqlBuilder example);

    /**
     * deleteBySQL
     *
     * @param example example
     * @return int int
     */
    int deleteBySQL(ScreeningSqlBuilder example);

    /**
     * deleteByPrimaryKey
     *
     * @param id id
     * @return int int
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * insert
     *
     * @param record record
     * @return int int
     */
    int insert(ScreeningDAO record);

    /**
     * insertSelective
     *
     * @param record record
     * @return int int
     */
    int insertSelective(ScreeningDAO record);

    /**
     * selectBySQL
     *
     * @param example example
     * @return List<Screening> List<Screening>
     */
    List<ScreeningDAO> selectBySQL(ScreeningSqlBuilder example);

    /**
     * selectByPrimaryKey
     *
     * @param id id
     * @return Screening Screening
     */
    ScreeningDAO selectByPrimaryKey(Integer id);

    /**
     * updateBySQLSelective
     *
     * @param record  record
     * @param example example
     * @return int int
     */
    int updateBySQLSelective(@Param("record") ScreeningDAO record, @Param("example") ScreeningSqlBuilder example);

    /**
     * updateBySQL
     *
     * @param record  record
     * @param example example
     * @return int int
     */
    int updateBySQL(@Param("record") ScreeningDAO record, @Param("example") ScreeningSqlBuilder example);

    /**
     * updateByPrimaryKeySelective
     *
     * @param record record
     * @return int int
     */
    int updateByPrimaryKeySelective(ScreeningDAO record);

    /**
     * updateByPrimaryKey
     *
     * @param record record
     * @return int int
     */
    int updateByPrimaryKey(ScreeningDAO record);
}