package com.policymanage.service.Impl;

import com.policymanage.activiti.entity.Process;
import com.policymanage.dao.ExamineDao;
import com.policymanage.dao.PolicyDao;
import com.policymanage.dao.ProcessDao;
import com.policymanage.entity.Examine;
import com.policymanage.entity.Policy;
import com.policymanage.service.ExamineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExamineServiceImpl implements ExamineService {
    @Autowired
    private ExamineDao examineDao;
    @Autowired
    private PolicyDao policyDao;
    @Autowired
    private ProcessDao processDao;

    @Override
    public List<Policy> findExistButExa() {
        // 获取所有审批信息
        List<Policy> policyList = policyDao.findAll();
        List<Policy> list = new ArrayList<>();
        // 挑选出审批信息中所有已存在的
        for (Policy policy : policyList) {
            Integer id = policy.getPolicyId();
            Examine examine = examineDao.findById(id);
            if (examine == null) {
                list.add(policy);
            }
        }
        return list;
    }

    @Override
    public List<Policy> findMyExaTask(String ASSIGNEE_) {
        // 通过使用者在task列表中查询所属任务
        List<Process> list = processDao.findByASSIGNEE(ASSIGNEE_);
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
        return policyList;
    }

    @Override
    public List<Examine> findAll() {
        return examineDao.findAll();
    }

    @Override
    public void insertExamine(Examine examine) {
        examineDao.insertExamine(examine);
    }

    @Override
    public Examine findById(Integer examineId) {
        return examineDao.findById(examineId);
    }

    @Override
    public void updateExamine(Examine examine) {
        examineDao.updateExamine(examine);
    }
}
