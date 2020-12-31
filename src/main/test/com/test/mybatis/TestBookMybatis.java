package com.test.mybatis;

import com.policymanage.dao.BookDao;
import com.policymanage.dao.UserDao;
import com.policymanage.entity.Book;
import com.policymanage.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestBookMybatis {
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
    public void testFindAll() {
        BookDao bookDao = session.getMapper(BookDao.class);
        List<Book> lists = bookDao.findAll();
        for (Book list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void test2() {
        BookDao bookDao = session.getMapper(BookDao.class);
        UserDao userDao = session.getMapper(UserDao.class);
        User user = userDao.getByUserName("clerk");
        Integer id = user.getId();
        List<Book> book = bookDao.findByUserid(id);
        for (Book i : book) {
            System.out.println(i);
        }
    }
}
