package com.application.db;

import org.apache.ibatis.session.SqlSession;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/1-23:53
 * @Project: comp3013j_assignment
 * @Package: com.util
 * @Description:
 **/
public class DatabaseUtil {
    //A database util for query and insert
    public static void query(QueryStatement queryListener) {
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

    public static void insert(QueryStatement queryListener) {
        SqlSession sqlSession = null;
        try {
            sqlSession = MyBatisUtils.openSession();
            queryListener.query_commands(sqlSession);
            //For insert, we need to commit the change
            sqlSession.commit();
        } catch (Exception e) {
            throw e;
        } finally {
            MyBatisUtils.closeSession(sqlSession);
        }
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                SqlSession sqlSession = null;
//                try {
//                    sqlSession = MyBatisUtils.openSession();
//                    queryListener.query_commands(sqlSession);
//                    sqlSession.commit();
//                } catch (Exception e) {
//                    throw e;
//                } finally {
//                    MyBatisUtils.closeSession(sqlSession);
//                }
//            }
//        }).start();
    }

}
