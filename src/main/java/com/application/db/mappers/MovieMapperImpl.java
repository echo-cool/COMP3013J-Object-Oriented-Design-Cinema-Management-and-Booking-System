package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.db.builders.MovieSqlBuilder;
import com.application.db.dao.MovieDAO;
import com.application.models.Movie;
import com.application.models.persistent.MoviePersistent;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
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
    private Movie result;
    private Movie[] resultList = null;

    public boolean addMovie(Movie movie) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                MovieDAO dao = new MovieDAO();
                dao.setName(movie.getName());
                dao.setDuration(movie.getDuration());
                movieMapper.insert(dao);
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
                MovieDAO movieDAO = movieMapper.selectByPrimaryKey(movie_id);
                result = new Movie(
                        movieDAO.getName(),
                        movieDAO.getDuration()
                );
                id_cache.put(movie_id, movieDAO);
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
                MovieSqlBuilder movieSqlBuilder = new MovieSqlBuilder();
                movieSqlBuilder
                        .createCriteria()
                        .andNameEqualTo(movie_name);

                List<MovieDAO> tmp = movieMapper.selectBySQL(movieSqlBuilder);
                if (tmp.size() > 0) {
                    result = new Movie(
                            tmp.get(0).getName(),
                            tmp.get(0).getDuration()
                    );
                    name_cache.put(movie_name, tmp.get(0));
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
                MovieSqlBuilder movieSqlBuilder = new MovieSqlBuilder();
                movieSqlBuilder
                        .createCriteria()
                        .andIdIsNotNull();
                List<MovieDAO> tmp = movieMapper.selectBySQL(movieSqlBuilder);
                ArrayList<Movie> res = new ArrayList<>();
                for (MovieDAO m : tmp) {
                    Movie movie = new Movie(
                            m.getName(),
                            m.getDuration()
                    );
                    res.add(movie);
                }
                resultList = res.toArray(new Movie[]{});
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
