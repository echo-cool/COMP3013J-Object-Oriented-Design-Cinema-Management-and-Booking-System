package com.application.db.mappers;

import com.application.models.Movie;
import com.application.models.MovieSqlBuilder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MovieMapper {
    /**
    * countBySQL
    * @param example example
    * @return long long
    */
    long countBySQL(MovieSqlBuilder example);

    /**
    * deleteBySQL
    * @param example example
    * @return int int
    */
    int deleteBySQL(MovieSqlBuilder example);

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
    * selectBySQL
    * @param example example
    * @return List<Movie> List<Movie>
    */
    List<Movie> selectBySQL(MovieSqlBuilder example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Movie Movie
    */
    Movie selectByPrimaryKey(Integer id);

    /**
    * updateBySQLSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQLSelective(@Param("record") Movie record, @Param("example") MovieSqlBuilder example);

    /**
    * updateBySQL
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQL(@Param("record") Movie record, @Param("example") MovieSqlBuilder example);

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