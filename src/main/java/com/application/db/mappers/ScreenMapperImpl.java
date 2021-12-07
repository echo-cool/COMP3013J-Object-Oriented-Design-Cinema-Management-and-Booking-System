package com.application.db.mappers;

import com.application.db.DatabaseUtil;
import com.application.db.QueryStatement;
import com.application.models.Screen;
import org.apache.ibatis.session.SqlSession;

/**
 * @Author: WangYuyang
 * @Date: 2021/12/7-12:20
 * @Project: comp3013j_assignment
 * @Package: com.application.db.mappers
 * @Description:
 **/
public class ScreenMapperImpl {

    private Screen result;
    public Screen getScreenForOid(int sno) {
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
