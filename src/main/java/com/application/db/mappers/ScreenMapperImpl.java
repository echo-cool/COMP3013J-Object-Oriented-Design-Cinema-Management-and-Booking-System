package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.db.builders.ScreenSqlBuilder;
import com.application.db.dao.ScreenDAO;
import com.application.models.Screen;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/7-12:20
 * @Project: comp3013j_assignment
 * @Package: com.application.db.mappers
 * @Description:
 **/
public class ScreenMapperImpl {

    private Screen result;
    private Screen[] resultArray;

    public Screen[] getScreens() {
        resultArray = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreenSqlBuilder example = new ScreenSqlBuilder();
                example.createCriteria()
                        .andIdIsNotNull();
                example.setOrderByClause("id");
                List<ScreenDAO> tmp = sqlSession.getMapper(ScreenMapper.class).selectBySQL(example);
                ArrayList<Screen> screens = new ArrayList<>();
                for (ScreenDAO dao : tmp) {
                    Screen screen = new Screen(
                            dao.getName(),
                            dao.getCapacity()
                    );
                    screens.add(screen);
                }
                resultArray = screens.toArray(new Screen[]{});
            }
        });
        return resultArray;
    }

    public Screen getScreenForOid(int sno) {
        result = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreenDAO tmp = sqlSession.getMapper(ScreenMapper.class).selectByPrimaryKey(sno);
                result = new Screen(
                        tmp.getName(),
                        tmp.getCapacity()
                );
            }
        });
        return result;
    }

}
