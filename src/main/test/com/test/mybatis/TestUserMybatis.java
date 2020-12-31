package com.test.mybatis;

import com.policymanage.activiti.entity.History;
import com.policymanage.dao.UserDao;
import com.policymanage.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TestUserMybatis {
    private InputStream in;
    private SqlSessionFactory factory;
    private SqlSession session;

    @Before
    public void before() throws Exception {
        // 加载Mybatis配置文件
        in = Resources.getResourceAsStream("sqlMapConfig.xml");
        // 创建sqlSessionFactory对象
        factory = new SqlSessionFactoryBuilder().build(in);
        // 创建SqlSession对象
        session = factory.openSession();
    }

    @After
    public void after() throws Exception {
        session.commit();
        session.close();
        in.close();
    }

    @Test
    public void test1() {
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.getByUserName("yangqing");
        System.out.println(user);
    }

    @Test
    public void test2() {
        UserDao userDao = session.getMapper(UserDao.class);
        Set<String> roles = userDao.getRoles("yangqing");
        for (String role : roles) {
            System.out.println(role);
        }
    }

    @Test
    public void test3() {
        UserDao userDao = session.getMapper(UserDao.class);
        Set<String> permissions = userDao.getPermissions("yangqing");
        for (String permission : permissions) {
            System.out.println(permission);
        }
    }

    @Test
    public void test4() {
        UserDao userDao = session.getMapper(UserDao.class);
        String user = userDao.FindNameById(1);
        System.out.println(user);
    }

    @Test
    public void test5() {
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> all = userDao.findAll();
        for (User t : all) {
            System.out.println(t);
        }
        List<User> list = new ArrayList<>();
        for (User user : all) {
            if (user.getRoleId().equals(5)) {
                list.add(user);
            }
        }
        for (User i : list) {
            System.out.println(i);
        }
    }

    @Test
    public void test6() {
        UserDao userDao = session.getMapper(UserDao.class);
        List<User> all = userDao.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        User user = userDao.findById(1);
        System.out.println(user);
    }

    @Test
    public void test7() {
        UserDao userDao = session.getMapper(UserDao.class);
        List<History> history = userDao.findDoneNum("examine");
        for (History i : history) {
            System.out.println(i);
        }
    }

    @Test
    public void test8() {
        UserDao userDao = session.getMapper(UserDao.class);
        User clerk = userDao.getByUserName("clerk");
        System.out.println(clerk);
    }

    @Test
    public void test9() {
        UserDao userDao = session.getMapper(UserDao.class);
        String role = userDao.findRoleById(2);
        System.out.println(role);
    }
}
