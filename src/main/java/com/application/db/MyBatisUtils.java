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
 * */

public class MyBatisUtils {
    //利用static（静态）属于类不属于对象，且全局唯一，static属性本身就属于全局唯一
    private static SqlSessionFactory sqlSessionFactory = null;

    //利用静态块在初始化时实例化sqlSessionFactory
    static {
        Reader reader = null;
        try {
            reader = Resources.getResourceAsReader("mybatis-config.xml");
        } catch (IOException e) {
            e.printStackTrace();
            //初始化遇到错误时，将异常抛给调用者
            throw new ExceptionInInitializerError(e);
        }
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
    }

    //定义返回SqlSession对象的方法
    public static SqlSession openSession(){
        return sqlSessionFactory.openSession();
    }
    //释放SqlSession对象
    public static void closeSession(SqlSession session){
        if (session != null) {
            session.close();
        }
    }
}