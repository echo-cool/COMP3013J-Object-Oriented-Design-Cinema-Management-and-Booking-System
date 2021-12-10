package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.db.builders.MovieSqlBuilder;
import com.application.db.builders.ScreenSqlBuilder;
import com.application.db.builders.ScreeningSqlBuilder;
import com.application.db.dao.MovieDAO;
import com.application.db.dao.ScreenDAO;
import com.application.db.dao.ScreeningDAO;
import com.application.models.Movie;
import com.application.models.Screen;
import com.application.models.Screening;
import com.application.models.persistent.MoviePersistent;
import com.application.models.persistent.ScreenPersistent;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/7-12:20
 * @Project: comp3013j_assignment
 * @Package: com.application.db.mappers
 * @Description:
 **/
public class ScreeningMapperImpl {
    private List<Screening> result;

    public Screening[] getScreenings(LocalDate date) {
        result = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                ScreenMapper screenMapper = sqlSession.getMapper(ScreenMapper.class);
                ScreeningSqlBuilder example = new ScreeningSqlBuilder();
                DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
                System.out.println(date.format(dtf));
                example
                        .createCriteria()
                        .andDateEqualTo(date.format(dtf));
                ArrayList queryResult = new ArrayList();
                for (ScreeningDAO s : mapper.selectBySQL(example)) {
                    MovieDAO movieDAO = movieMapper.selectByPrimaryKey(s.getMovieId());
                    MoviePersistent moviePersistent = new MoviePersistent(
                            movieDAO.getName(),
                            movieDAO.getDuration(),
                            movieDAO.getId()
                    );
                    ScreenDAO screeningDAO = screenMapper.selectByPrimaryKey(s.getScreenId());
                    ScreenPersistent screenPersistent = new ScreenPersistent(
                            screeningDAO.getName(),
                            screeningDAO.getCapacity(),
                            screeningDAO.getId()
                    );

                    queryResult.add(new Screening(
                            LocalTime.parse(s.getStartTime()),
                            LocalDate.parse(s.getDate()),
                            s.getTicketSold(),
                            moviePersistent,
                            screenPersistent
                    ));
                }
                result = queryResult;
            }
        });
        return result.toArray(new Screening[result.size()]);
    }

    public void updateScreening(Screening selected) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                MovieMapper movieMapper = sqlSession.getMapper(MovieMapper.class);
                ScreenMapper screenMapper = sqlSession.getMapper(ScreenMapper.class);
                ScreeningDAO screeningDAO = new ScreeningDAO();
                screeningDAO.setDate(selected.getDate().format(DateTimeFormatter.ISO_DATE));
                screeningDAO.setStartTime(selected.getStartTime().format(DateTimeFormatter.ISO_TIME));
                screeningDAO.setTicketSold(selected.getTicketSold());
                ScreenSqlBuilder screenSqlBuilder = new ScreenSqlBuilder();
                screenSqlBuilder
                        .createCriteria()
                        .andNameEqualTo(selected.getScreen().getName())
                        .andCapacityEqualTo(selected.getScreen().getCapacity());
                ScreenDAO screenDAO = screenMapper.selectBySQL(screenSqlBuilder).get(0);
                screeningDAO.setScreenId(screenDAO.getId());

                MovieSqlBuilder movieSqlBuilder = new MovieSqlBuilder();
                movieSqlBuilder
                        .createCriteria()
                        .andNameEqualTo(selected.getMovie().getName())
                        .andDurationEqualTo(selected.getMovie().getDuration());
                MovieDAO movieDAO = movieMapper.selectBySQL(movieSqlBuilder).get(0);
                screeningDAO.setMovieId(movieDAO.getId());

                mapper.updateByPrimaryKey(screeningDAO);
            }
        });

    }

    public void deleteScreening(Screening selected) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                ScreeningSqlBuilder screeningSqlBuilder = new ScreeningSqlBuilder();
                screeningSqlBuilder.createCriteria()
                        .andDateEqualTo(selected.getDate().format(DateTimeFormatter.ISO_DATE))
                        .andStartTimeEqualTo(selected.getStartTime().format(DateTimeFormatter.ISO_TIME));
                mapper.deleteByPrimaryKey(mapper.selectBySQL(screeningSqlBuilder).get(0).getScreenId());
            }
        });
    }

    public void scheduleScreening(LocalDate date, LocalTime start_time, Screen screen, Movie movie) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                MovieDAO movieDAO = new MovieDAO();
                movieDAO.setName(movie.getName());
                movieDAO.setDuration(movie.getDuration());
                ScreenDAO screenDAO = new ScreenDAO();
                screenDAO.setName(screen.getName());
                screenDAO.setCapacity(screen.getCapacity());
                ScreeningDAO screeningDAO = new ScreeningDAO(date, start_time, 0, movieDAO, screenDAO);
                mapper.insert(screeningDAO);
            }
        });

    }
}
