package com.application.db.mappers;

import com.application.models.Movie;
import com.application.models.MovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface MovieMapper {
    /**
    * countByExample
    * @param example example
    * @return long long
    */
    long countByExample(MovieExample example);

    /**
    * deleteByExample
    * @param example example
    * @return int int
    */
    int deleteByExample(MovieExample example);

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
    int insert(Movie record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(Movie record);

    /**
    * selectByExample
    * @param example example
    * @return List<Movie> List<Movie>
    */
    List<Movie> selectByExample(MovieExample example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Movie Movie
    */
    Movie selectByPrimaryKey(Integer id);

    /**
    * updateByExampleSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExampleSelective(@Param("record") Movie record, @Param("example") MovieExample example);

    /**
    * updateByExample
    * @param record record
    * @param example example
    * @return int int
    */
    int updateByExample(@Param("record") Movie record, @Param("example") MovieExample example);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(Movie record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(Movie record);

}