package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.models.Movie;
import com.application.models.Screen;
import com.application.models.Screening;
import com.application.models.ScreeningExample;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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
                ScreeningExample example = new ScreeningExample();
                DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
                System.out.println(date.format(dtf));
                example
                        .createCriteria()
                        .andDateEqualTo(date.format(dtf));
                result = mapper.selectByExample(example);
            }
        });
        return result.toArray(new Screening[result.size()]);
    }

    public void updateScreening(Screening selected) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                mapper.updateByPrimaryKey(selected);
            }
        });

    }

    public void deleteScreening(Screening screening) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                mapper.deleteByPrimaryKey(screening.getId());
            }
        });
    }

    public void scheduleScreening(LocalDate date, LocalTime start_time, Screen screen, Movie movie) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
//                Screening screening = new Screening(date, start_time, 0, movie, screen);
//                mapper.insert(screening);
            }
        });

    }
}
