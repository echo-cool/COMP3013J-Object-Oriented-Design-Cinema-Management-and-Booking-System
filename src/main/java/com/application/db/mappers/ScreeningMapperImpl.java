package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.db.builders.ScreeningSqlBuilder;
import com.application.db.dao.MovieDAO;
import com.application.db.dao.ScreenDAO;
import com.application.db.dao.ScreeningDAO;
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
    private List<ScreeningDAO> result;

    public ScreeningDAO[] getScreenings(LocalDate date) {
        result = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                ScreeningSqlBuilder example = new ScreeningSqlBuilder();
                DateTimeFormatter dtf = DateTimeFormatter.ISO_DATE;
                System.out.println(date.format(dtf));
                example
                        .createCriteria()
                        .andDateEqualTo(date.format(dtf));
                result = mapper.selectBySQL(example);
            }
        });
        return result.toArray(new ScreeningDAO[result.size()]);
    }

    public void updateScreening(ScreeningDAO selected) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                mapper.updateByPrimaryKey(selected);
            }
        });

    }

    public void deleteScreening(ScreeningDAO screeningDAO) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
//                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
//                mapper.deleteByPrimaryKey(screening.getId());
            }
        });
    }

    public void scheduleScreening(LocalDate date, LocalTime start_time, ScreenDAO screenDAO, MovieDAO movieDAO) {
        DatabaseUtil.insert(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
                ScreeningDAO screeningDAO = new ScreeningDAO(date, start_time, 0, movieDAO, screenDAO);
                mapper.insert(screeningDAO);
            }
        });

    }
}
