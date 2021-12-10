package com.application.db;

import org.apache.ibatis.session.SqlSession;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/1-23:53
 * @Project: comp3013j_assignment
 * @Package: com.util
 * @Description:
 **/
public interface QueryStatement {
    //A call back method for the query statement
    void query_commands(SqlSession sqlSession);
}
