package com.test.mybatis;

import com.policymanage.dao.AssessDao;
import com.policymanage.dao.EnterpriseDao;
import com.policymanage.entity.Assess;
import com.policymanage.entity.Enterprise;
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

public class TestAssessMybatis {
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
        AssessDao assessDao = session.getMapper(AssessDao.class);
        List<Assess> lists = assessDao.findAll();
        for (Assess list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void findExistButAsses() {
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        AssessDao assessDao = session.getMapper(AssessDao.class);
        // 获取所有企业信息
        List<Enterprise> enterpriseList = enterpriseDao.findAll();
        List<Enterprise> list = new ArrayList<>();
        List<Enterprise> assessList = new ArrayList<>();
        // 挑选出所有属于固定资产投资公司的企业
        for (Enterprise enterprise : enterpriseList) {
            if (enterprise.getEnterpriseFund() > 5000000) {
                list.add(enterprise);
            }
        }
        for (Enterprise en : list) {
            System.out.println(en);
        }
        // 从上个循环挑选出来的list中获取还不存在评估信息的
        for (Enterprise enterprise : list) {
            Integer id = enterprise.getEnterpriseId();
            Assess assess = assessDao.findById(id);
            if (assess == null) {
                assessList.add(enterprise);
            }
        }
        for (Enterprise enterprise : assessList) {
            System.out.println(enterprise);
        }
    }
}
