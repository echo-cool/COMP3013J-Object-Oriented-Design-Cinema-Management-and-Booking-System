package com.util;

import com.mapper.AdminUserMapper;
import com.model.AdminUser;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.Connection;

import static org.junit.Assert.*;

/**
 * @Author: WangYuyang
 * @Date: 2021/10/1-19:05
 * @Project: comp3013j_assignment
 * @Package: com.util
 * @Description:
 **/
public class MyBatisUtilsTest {

    @Test
    public void openSession() {
        SqlSession sqlSession = null;
        try {
            //一句话完成SqlSession的初始化工作
            sqlSession = MyBatisUtils.openSession();
            //执行数据库操作
            //sqlSession.insert()
            //sqlSession.update()
            Connection connection = sqlSession.getConnection();
            System.out.println(connection);
            AdminUserMapper adminUserMapper = sqlSession.getMapper(AdminUserMapper.class);
            AdminUser adminUser = adminUserMapper.selectByPrimaryKey(1);
            System.out.println(adminUser);
            assertNotNull(adminUser);
            assertNotNull(connection);

        } catch (Exception e) {
            throw e;
        } finally {
            //关闭数据连接
            MyBatisUtils.closeSession(sqlSession);
        }
    }
}