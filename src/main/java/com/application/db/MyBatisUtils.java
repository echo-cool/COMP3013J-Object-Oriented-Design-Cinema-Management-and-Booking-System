package com.application.db;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/1-19:03
 * @Project: comp3013j_assignment
 * @Package: com.util
 * @Description:
 **/

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

/**
 * MyBatisUtilsgoon工具类，创建全局唯一的SqlSessionFactory对象
 */

public class MyBatisUtils {
    //Init static sqlSessionFactory
    private static SqlSessionFactory sqlSessionFactory = null;

    //Using static block to init sqlSessionFactory
    static {
        Reader reader = null;
        try {
            //Load config
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
            throw new ExceptionInInitializerError(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    //Return the session
    public static SqlSession openSession() {
        return sqlSessionFactory.openSession();
    }

    //Close session
    public static void closeSession(SqlSession session) {
        if (session != null) {
            session.close();
        }
    }
}