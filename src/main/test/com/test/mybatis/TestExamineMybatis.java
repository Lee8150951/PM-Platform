package com.test.mybatis;

import com.policymanage.activiti.entity.Process;
import com.policymanage.dao.ExamineDao;
import com.policymanage.dao.PolicyDao;
import com.policymanage.dao.ProcessDao;
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

public class TestExamineMybatis {
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
        ProcessDao processDao = session.getMapper(ProcessDao.class);
        PolicyDao policyDao = session.getMapper(PolicyDao.class);
        // 通过使用者在task列表中查询所属任务
        List<Process> list = processDao.findByASSIGNEE("examine");
        List<String> ids = new ArrayList<>();
        // 遍历list表，获取EXECUTION_ID_
        for (Process process : list) {
            String executionId = process.getEXECUTION_ID_();
            ids.add(executionId);
        }
        // 遍历ids获取单个EXECUTION_ID_并查询BUSINESS_KEY_
        List<Policy> policyList = new ArrayList<>();
        for (String id : ids) {
            String key = processDao.getKeyByProcess(id);
            // 通过Key查询政策
            Policy policy = policyDao.selectById(key);
            // 将policy存储至list中
            policyList.add(policy);
        }
        for (Policy policy : policyList) {
            System.out.println(policy);
        }
    }

    @Test
    public void test1() {
        ExamineDao examineDao = session.getMapper(ExamineDao.class);
        Examine examine = examineDao.findById(123123);
        System.out.println(examine);
        List<Examine> all = examineDao.findAll();
        for (Examine i : all) {
            System.out.println(i);
            Integer id = i.getExamineId();
            System.out.println(examineDao.findById(id));
        }
    }

    @Test
    public void test2() {
        ExamineDao examineDao = session.getMapper(ExamineDao.class);
        Examine examine = examineDao.findByEnterprise("111");
        System.out.println(examine);
    }
}
