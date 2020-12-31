package com.policymanage.service.Impl;

import com.policymanage.activiti.entity.Process;
import com.policymanage.dao.AssessDao;
import com.policymanage.dao.EnterpriseDao;
import com.policymanage.dao.ProcessDao;
import com.policymanage.entity.Assess;
import com.policymanage.entity.Enterprise;
import com.policymanage.service.AssessService;
import com.policymanage.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class AssessServiceImpl implements AssessService {
    @Autowired
    private AssessDao assessDao;
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Autowired
    private ProcessDao processDao;

    @Override
    public List<Assess> findAll() {
        return assessDao.findAll();
    }

    @Override
    public Enterprise findEnterpriseById(Integer assessId) {
        return enterpriseDao.findById(assessId);
    }

    @Override
    public void insertAssess(Assess assess) {
        assessDao.insertAssess(assess);
    }

    @Override
    public void updatePathById(String assessPath, Integer assessId) {
        assessDao.updatePathById(assessPath, assessId);
    }

    @Override
    public Assess findById(Integer assessId) {
        return assessDao.findById(assessId);
    }

    @Override
    public void deleteAssess(Integer assessId) {
        assessDao.deleteAssess(assessId);
    }

    @Override
    public void updateAssess(Assess assess) {
        assessDao.updateAssess(assess);
    }

    @Override
    public List<Assess> queryAssess(Integer queryKind, String queryContent) {
        List<Assess> list = new ArrayList<Assess>();
        switch (queryKind) {
            case 1:
                /*根据企业名称查询*/
                List<Enterprise> enterprises = enterpriseDao.findByName(queryContent);
                for (Enterprise enterprise : enterprises) {
                    Assess assess = assessDao.findById(enterprise.getEnterpriseId());
                    list.add(assess);
                }
                break;
            case 2:
                list = assessDao.findByName(queryContent);
                break;
        }
        return list;
    }

    @Override
    public List<Assess> queryByTimeBucket(String beginDate, String endDate) {
        List<Assess> list = new ArrayList<>();
        try {
            /*获取时间段内所有时间集合*/
            List<String> dateStrs = DateUtils.getDayListOfDateStr(beginDate, endDate);
            /*循环遍历集合内所有时间*/
            assert dateStrs != null;
            for (String dateStr : dateStrs) {
                /*将dateStr转换为Date格式*/
                Date date = DateUtils.parseStrToDate(dateStr);
                /*通过转换后的Date数据对数据库进行查询并存储至assessList*/
                List<Assess> assessList = assessDao.findByTime(date);
                /*遍历assessList将其中元素加入list中*/
                list.addAll(assessList);
            }
            return list;
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean AddQueryEnterprise(Integer assessId) {
        Enterprise enterprise = enterpriseDao.findById(assessId);
        if (enterprise == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean AddQueryAssess(Integer assessId) {
        Assess assess = assessDao.findById(assessId);
        if (assess == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Enterprise> findExistButAssess() {
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
        // 从上个循环挑选出来的list中获取还不存在评估信息的
        for (Enterprise enterprise : list) {
            Integer id = enterprise.getEnterpriseId();
            Assess assess = assessDao.findById(id);
            if (assess == null) {
                assessList.add(enterprise);
            }
        }
        return assessList;
    }

    @Override
    public List<Enterprise> findMyAssess(String ASSIGNEE_) {
        // 通过使用者在task列表中查询所属任务
        List<Process> list = processDao.findByASSIGNEE(ASSIGNEE_);
        List<String> ids = new ArrayList<>();
        // 遍历list表，获取EXECUTION_ID_
        for (Process process : list) {
            String executionId = process.getEXECUTION_ID_();
            ids.add(executionId);
        }
        // 遍历ids获取单个EXECUTION_ID_并查询BUSINESS_KEY_
        List<Enterprise> enterpriseList = new ArrayList<>();
        for (String id : ids) {
            String key = processDao.getKeyByProcess(id);
            // 转换为Integer类型
            Integer i = Integer.valueOf(key);
            // 通过Key查询企业信息
            Enterprise enterprise = enterpriseDao.findById(i);
            // 将enterprise存储至list中
            enterpriseList.add(enterprise);
        }
        return enterpriseList;
    }
}
