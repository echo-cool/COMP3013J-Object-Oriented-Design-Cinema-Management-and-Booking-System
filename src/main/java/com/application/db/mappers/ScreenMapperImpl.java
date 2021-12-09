package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.db.builders.ScreenSqlBuilder;
import com.application.db.dao.ScreenDAO;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/7-12:20
 * @Project: comp3013j_assignment
 * @Package: com.application.db.mappers
 * @Description:
 **/
public class ScreenMapperImpl {

    private ScreenDAO result;
    private ScreenDAO[] resultArray;

    public ScreenDAO[] getScreens() {
        resultArray = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                ScreenSqlBuilder example = new ScreenSqlBuilder();
                example.createCriteria()
                        .andIdIsNotNull();
                example.setOrderByClause("id");
                resultArray = sqlSession.getMapper(ScreenMapper.class).selectBySQL(example).toArray(new ScreenDAO[]{});
            }
        });
        return resultArray;
    }

    public ScreenDAO getScreenForOid(int sno) {
        result = null;
        DatabaseUtil.query(new QueryStatement() {
            @Override
            public void query_commands(SqlSession sqlSession) {
                result = sqlSession.getMapper(ScreenMapper.class).selectByPrimaryKey(sno);
            }
        });
        return result;
    }

}
