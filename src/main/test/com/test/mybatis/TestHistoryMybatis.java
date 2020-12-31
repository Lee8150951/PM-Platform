package com.test.mybatis;

import com.policymanage.activiti.entity.History;
import com.policymanage.dao.HistoryDao;
import com.policymanage.dao.UserDao;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestHistoryMybatis {
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
        HistoryDao historyDao = session.getMapper(HistoryDao.class);
        List<History> all = historyDao.findAll();
        for (History i : all) {
            System.out.println(i);
        }
    }

    @Test
    public void test2() {
        HistoryDao historyDao = session.getMapper(HistoryDao.class);
        List<History> all = historyDao.findByName("examine");
        for (History i : all) {
            System.out.println(i);
        }
    }
}
