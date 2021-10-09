package com.mapper;

import com.model.Movie;
import com.model.MovieExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
    * @param ID ID
    * @return int int
    */
    int deleteByPrimaryKey(Integer ID);

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
    * @param ID ID
    * @return Movie Movie
    */
    Movie selectByPrimaryKey(Integer ID);

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