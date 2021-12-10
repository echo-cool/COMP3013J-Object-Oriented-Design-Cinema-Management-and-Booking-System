package com.application.db.mappers;

import com.application.db.builders.MovieSqlBuilder;
import com.application.db.dao.MovieDAO;
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
    int insert(MovieDAO record);

    /**
    * insertSelective
    * @param record record
    * @return int int
    */
    int insertSelective(MovieDAO record);

    /**
    * selectBySQL
    * @param example example
    * @return List<Movie> List<Movie>
    */
    List<MovieDAO> selectBySQL(MovieSqlBuilder example);

    /**
    * selectByPrimaryKey
    * @param id id
    * @return Movie Movie
    */
    MovieDAO selectByPrimaryKey(Integer id);

    /**
    * updateBySQLSelective
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQLSelective(@Param("record") MovieDAO record, @Param("example") MovieSqlBuilder example);

    /**
    * updateBySQL
    * @param record record
    * @param example example
    * @return int int
    */
    int updateBySQL(@Param("record") MovieDAO record, @Param("example") MovieSqlBuilder example);

    /**
    * updateByPrimaryKeySelective
    * @param record record
    * @return int int
    */
    int updateByPrimaryKeySelective(MovieDAO record);

    /**
    * updateByPrimaryKey
    * @param record record
    * @return int int
    */
    int updateByPrimaryKey(MovieDAO record);
}