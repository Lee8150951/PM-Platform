package com.test.mybatis;

import com.policymanage.dao.EnterpriseDao;
import com.policymanage.dao.ExamineDao;
import com.policymanage.dao.PolicyDao;
import com.policymanage.entity.Enterprise;
import com.policymanage.entity.Examine;
import com.policymanage.entity.Policy;
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

public class TestPolicyMybatis {
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
        PolicyDao policyDao = session.getMapper(PolicyDao.class);
        Policy policy = new Policy();
        policy.setPolicyEnterprise("企业名称");
        policy.setPolicyBank("招商银行");
        Integer policyId = 76543;
        policyDao.insertID(policyId);
        policyDao.updatePolicy(policy, policyId);
    }

    @Test
    public void test2() {
        PolicyDao policyDao = session.getMapper(PolicyDao.class);
        List<Policy> list = policyDao.findAll();
        for (Policy policy : list) {
            System.out.println(policy);
        }
    }

    @Test
    public void test3() {
        PolicyDao policyDao = session.getMapper(PolicyDao.class);
        policyDao.insertID(1);
    }

    @Test
    public void test4() {
        PolicyDao policyDao = session.getMapper(PolicyDao.class);
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        Enterprise enterprise = enterpriseDao.findIdByUser("clerk");
        Integer id = enterprise.getEnterpriseId();
        Policy policy = new Policy();
        policy.setPolicyEnterprise("哔哩哔哩");
        policy.setPolicyId(id);
        System.out.println(policy);
        policyDao.insertPolicy(policy);
    }

    @Test
    public void test5() {
        PolicyDao policyDao = session.getMapper(PolicyDao.class);
        ExamineDao examineDao = session.getMapper(ExamineDao.class);
        List<Policy> policyList = policyDao.findAll();
        List<Policy> list = new ArrayList<>();
        for (Policy policy : policyList) {
            Integer id = policy.getPolicyId();
            Examine examine = examineDao.findById(id);
            if (examine == null) {
                list.add(policy);
            }
        }
        for (Policy policy : list) {
            System.out.println(policy);
        }
    }
}
