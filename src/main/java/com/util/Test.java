package com.util;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.db.mappers.MovieMapperImpl;
import com.application.db.mappers.ScreenMapperImpl;
import com.application.db.mappers.ScreeningMapper;
import com.application.db.mappers.ScreeningMapperImpl;
import com.application.models.Screen;
import org.apache.ibatis.session.SqlSession;

import java.time.LocalDate;
import java.time.LocalTime;

public class Test {
    public static void main(String[] args) {
        ScreeningMapperImpl screeningMapper=new ScreeningMapperImpl();
        ScreenMapperImpl screenMapper=new ScreenMapperImpl();
        MovieMapperImpl movieMapper=new MovieMapperImpl();
        screeningMapper.scheduleScreening(LocalDate.now(), LocalTime.now(),screenMapper.getScreenForOid(2),movieMapper.getMovie("haha0"));

//        DatabaseUtil.query(new QueryStatement() {
//            @Override
//            public void query_commands(SqlSession sqlSession) {
//                ScreeningMapper mapper = sqlSession.getMapper(ScreeningMapper.class);
//                System.out.println(mapper.selectByPrimaryKey(1));
//            }
//        });
        System.out.println(screeningMapper.getScreenings(LocalDate.now()).length);
    }
}
