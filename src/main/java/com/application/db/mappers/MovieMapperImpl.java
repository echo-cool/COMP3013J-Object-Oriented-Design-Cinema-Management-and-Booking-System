package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.db.builders.MovieSqlBuilder;
import com.application.db.dao.MovieDAO;
import org.apache.ibatis.session.SqlSession;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/7-12:20
 * @Project: comp3013j_assignment
 * @Package: com.application.db.mappers
 * @Description:
 **/
public class MovieMapperImpl {
    private final HashMap<Integer, MovieDAO> id_cache = new LinkedHashMap();
    private final HashMap<String, MovieDAO> name_cache = new LinkedHashMap();
    private MovieDAO result;
    private MovieDAO[] resultList = null;

    public boolean addMovie(MovieDAO movieDAO) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                movieMapper.insert(movieDAO);
                System.out.println("insert success");
            }
        });
        return true;
    }

    public MovieDAO getMovieForOid(Integer movie_id) {
        result = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                result = movieMapper.selectByPrimaryKey(movie_id);
                id_cache.put(movie_id, result);
            }
        });
        return result;
    }

    public MovieDAO getMovie(String movie_name) {
        result = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                MovieSqlBuilder movieSqlBuilder = new MovieSqlBuilder();
                movieSqlBuilder
                        .createCriteria()
                        .andNameEqualTo(movie_name);

                List<MovieDAO> tmp = movieMapper.selectBySQL(movieSqlBuilder);
                if (tmp.size() > 0) {
                    result = tmp.get(0);
                    name_cache.put(movie_name, result);
                }
            }
        });
        return result;
    }

    public MovieDAO[] getMovies() {
        resultList = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                MovieSqlBuilder movieSqlBuilder = new MovieSqlBuilder();
                movieSqlBuilder
                        .createCriteria()
                        .andIdIsNotNull();

                resultList = movieMapper.selectBySQL(movieSqlBuilder).toArray(new MovieDAO[]{});
            }
        });
        return resultList;
    }


    public MovieDAO getFromCacheByName(String movie_name) {
        return name_cache.get(movie_name);
    }

    public MovieDAO getFromCacheByNumber(Integer movie_id) {
        return id_cache.get(movie_id);
    }

}
