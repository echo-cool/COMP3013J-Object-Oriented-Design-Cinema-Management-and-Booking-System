package com.util;

import org.apache.ibatis.session.SqlSession;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/1-23:53
 * @Project: comp3013j_assignment
 * @Package: com.util
 * @Description:
 **/
public class DatabaseUtil {
    public static void query(QueryStatement queryListener){
        new Thread(new Runnable() {
            @Override
            public void run() {
                SqlSession sqlSession = null;
                try {
                    sqlSession = MyBatisUtils.openSession();
                    queryListener.query_commands(sqlSession);
                } catch (Exception e) {
                    throw e;
                } finally {
                    MyBatisUtils.closeSession(sqlSession);
                }
            }
        }).start();
    }
}
