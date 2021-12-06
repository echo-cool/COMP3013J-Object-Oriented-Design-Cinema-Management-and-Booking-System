package com.application.db.mappers;

import com.application.models.Screen;
import com.application.models.ScreenExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ScreenMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(ScreenExample example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(ScreenExample example);

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
    * selectByExample
    * @param example example
    * @return List<Screen> List<Screen>
    */
    List<Screen> selectByExample(ScreenExample example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Screen Screen
    */
    Screen selectByPrimaryKey(Integer id);

    /**
    * updateByExampleSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExampleSelective(@Param("record") Screen record, @Param("example") ScreenExample example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") Screen record, @Param("example") ScreenExample example);

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


    Screen getScreenForOid(int sno);
}