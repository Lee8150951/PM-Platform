package com.test.mybatis;

import com.policymanage.dao.CheckDao;
import com.policymanage.dao.ExamineDao;
import com.policymanage.entity.Check;
import com.policymanage.entity.Examine;
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

public class TestCheckMybatis {
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
        CheckDao checkDao = session.getMapper(CheckDao.class);
        List<Check> lists = checkDao.findAll();
        for (Check list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void test1() {
        CheckDao checkDao = session.getMapper(CheckDao.class);
        Check check = new Check();
        check.setCheckId(76543);
        check.setCheckResult("同意");
        checkDao.insertCheck(check);
    }

    @Test
    public void test2() {
        CheckDao checkDao = session.getMapper(CheckDao.class);
        ExamineDao examineDao = session.getMapper(ExamineDao.class);
        // 获取所有Examine信息
        List<Examine> list = examineDao.findAll();
        List<Examine> examineList = new ArrayList<>();
        // 遍历Examine列表
        for (Examine examine : list) {
            // 获取i的id
            Integer id = examine.getExamineId();
            // 查询Check表中是否有id对应信息
            Check check = checkDao.findById(id);
            if (check == null) {
                examineList.add(examine);
            }
        }
        for (Examine examine : examineList) {
            System.out.println(examine);
        }
    }
}
