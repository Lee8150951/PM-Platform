package com.test.mybatis;

import com.policymanage.dao.CompleteDao;
import com.policymanage.dao.FileDao;
import com.policymanage.dao.PolicyDao;
import com.policymanage.entity.Complete;
import com.policymanage.entity.File;
import com.policymanage.entity.Policy;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class TestFileMybatis {
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
        FileDao fileDao = session.getMapper(FileDao.class);
        List<File> list = fileDao.findAll();
        for (File file : list) {
            System.out.println(file);
        }
    }

    @Test
    public void test2() {
        CompleteDao completeDao = session.getMapper(CompleteDao.class);
        Complete complete = completeDao.findById(123123);
        System.out.println(complete);
    }
}
