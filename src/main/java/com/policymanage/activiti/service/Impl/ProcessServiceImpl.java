package com.policymanage.activiti.service.Impl;

import com.policymanage.activiti.entity.Process;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.dao.ProcessDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProcessServiceImpl implements ProcessService {
    @Autowired
    private ProcessDao processDao;
    @Override
    public List<Process> findAll() {
        return processDao.findAll();
    }

    @Override
    public List<Process> findByASSIGNEE(String ASSIGNEE_) {
        return processDao.findByASSIGNEE(ASSIGNEE_);
    }

    @Override
    public String getIdByAssignee(String ASSIGNEE_) {
        Process process = processDao.getIdByAssignee(ASSIGNEE_);
        String executionId = process.getEXECUTION_ID_();
        return processDao.getKeyByProcess(executionId);
    }

    @Override
    public void updateBUSIKeyById(Integer BUSINESS_KEY_, String ASSIGNEE_) {
        Process process = processDao.getIdByAssignee(ASSIGNEE_);
        String executionId = process.getEXECUTION_ID_();
        processDao.updateBUSIKeyById(BUSINESS_KEY_, executionId);
    }

    @Override
    public String findProByBUSI(Integer BUSINESS_KEY_) {
        String idByBUSIKey = processDao.findIdByBUSIKey(BUSINESS_KEY_);
        return processDao.findProById(idByBUSIKey);
    }

    @Override
    public String findProcessById(Integer BUSINESS_KEY_) {
        String idByBUSIKey = processDao.findIdByBUSIKey(BUSINESS_KEY_);
        Process process = processDao.findByEXEId(idByBUSIKey);
        return process.getNAME_();
    }
}
