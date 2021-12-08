package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.models.Movie;
import com.application.models.MovieExample;
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
    private HashMap<Integer, Movie> id_cache = new LinkedHashMap();
    private HashMap<String, Movie> name_cache = new LinkedHashMap();
    private Movie result;
    private Movie[] resultList = null;

    public boolean addMovie(Movie movie) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                movieMapper.insert(movie);
                System.out.println("insert success");
            }
        });
        return true;
    }

    public Movie getMovieForOid(Integer movie_id) {
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

    public Movie getMovie(String movie_name) {
        result = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                MovieExample movieExample = new MovieExample();
                movieExample
                        .createCriteria()
                        .andNameEqualTo(movie_name);

                List<Movie> tmp = movieMapper.selectByExample(movieExample);
                if (tmp.size() > 0) {
                    result = tmp.get(0);
                    name_cache.put(movie_name, result);
                }
            }
        });
        return result;
    }

    public Movie[] getMovies() {
        resultList = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                MovieExample movieExample = new MovieExample();
                movieExample
                        .createCriteria()
                        .andIdIsNotNull();

                resultList = movieMapper.selectByExample(movieExample).toArray(new Movie[]{});
            }
        });
        return resultList;
    }


    public Movie getFromCacheByName(String movie_name) {
        return name_cache.get(movie_name);
    }

    public Movie getFromCacheByNumber(Integer movie_id) {
        return id_cache.get(movie_id);
    }

}
