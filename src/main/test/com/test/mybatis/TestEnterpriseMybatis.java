package com.test.mybatis;

import com.policymanage.dao.EnterpriseDao;
import com.policymanage.entity.Enterprise;
import com.policymanage.utils.DateUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

public class TestEnterpriseMybatis {
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
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        List<Enterprise> lists = enterpriseDao.findAll();
        for (Enterprise list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void testInsert() {
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseId(2);
        enterprise.setEnterpriseName("阿里巴巴");
        enterprise.setEnterpriseRegaddress("英联邦开曼群岛");
        enterprise.setEnterpriseLegalman("马云");
        enterprise.setEnterprisePrincipal("朱一旦");
        enterprise.setEnterprisePhone("400-800-1688");
        enterprise.setEnterpriseFund(596900000);
        enterprise.setEnterpriseType("股份有限公司");
        enterprise.setEnterpriseRank("AAA");
        enterpriseDao.insertEnterprise(enterprise);
    }

    @Test
    public void testFindById() {
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        Enterprise enterprise = enterpriseDao.findById(1);
        System.out.println(enterprise);
    }

    @Test
    public void testAdd() {
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseName("歌谷");
        enterpriseDao.insertEnterprise(enterprise);
    }

    @Test
    public void testUpdatePath() {
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        enterpriseDao.updatePathById("D://", 123149);
    }

    @Test
    public void testUpdateAll() {
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        Enterprise enterprise = new Enterprise();
        enterprise.setEnterpriseId(123149);
        enterprise.setEnterpriseName("霸王");
        enterpriseDao.updateEnterprise(enterprise);
    }

    @Test
    public void testFindByPrincipal() {
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        List<Enterprise> lists = enterpriseDao.findByPrincipal("马");
        for (Enterprise list : lists) {
            System.out.println(list);
        }
    }

    @Test
    public void testFindByInTime() throws ParseException {
        EnterpriseDao enterpriseDao = session.getMapper(EnterpriseDao.class);
        String dateStr1 = "2018年6月5日";
        String dateStr2 = "2018.6.5";
        String dateStr3 = "20180605";
        String dateStr4 = "2018-06-05";
        Date date1 = DateUtils.parseStrToDate(dateStr1);
        Date date2 = DateUtils.parseStrToDate(dateStr2);
        Date date3 = DateUtils.parseStrToDate(dateStr3);
        Date date4 = DateUtils.parseStrToDate(dateStr4);
        List<Enterprise> lists1 = enterpriseDao.findByInTime(date1);
        for (Enterprise list : lists1) {
            System.out.println(list);
        }
        List<Enterprise> lists2 = enterpriseDao.findByInTime(date2);
        for (Enterprise list : lists2) {
            System.out.println(list);
        }
        List<Enterprise> lists3 = enterpriseDao.findByInTime(date3);
        for (Enterprise list : lists3) {
            System.out.println(list);
        }
        List<Enterprise> lists4 = enterpriseDao.findByInTime(date4);
        for (Enterprise list : lists4) {
            System.out.println(list);
        }
    }
}
