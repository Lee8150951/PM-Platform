package com.policymanage.service.Impl;

import com.policymanage.activiti.entity.Process;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.dao.CheckDao;
import com.policymanage.dao.ExamineDao;
import com.policymanage.dao.ProcessDao;
import com.policymanage.entity.Check;
import com.policymanage.entity.Examine;
import com.policymanage.service.CheckService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CheckServiceImpl implements CheckService {
    @Autowired
    private CheckDao checkDao;
    @Autowired
    private ExamineDao examineDao;
    @Autowired
    private ProcessDao processDao;
    @Override
    public List<Check> findAll() {
        return checkDao.findAll();
    }

    @Override
    public void insertCheck(Check check) {
        checkDao.insertCheck(check);
    }

    @Override
    public List<Examine> findAllNoCheck() {
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
        return examineList;
    }

    @Override
    public List<Examine> findAllNone() {
        List<Process> list = processDao.findByASSIGNEE("leader");
        List<String> ids = new ArrayList<>();
        for (Process process : list) {
            String executionId = process.getEXECUTION_ID_();
            ids.add(executionId);
        }
        List<Examine> examineList = new ArrayList<>();
        for (String id : ids) {
            String key = processDao.getKeyByProcess(id);
            // 将id转换为Integer类型
            Integer i = Integer.parseInt(key);
            Examine examine = examineDao.findById(i);
            examineList.add(examine);
        }
        return examineList;
    }

    @Override
    public void updateCheck(Check check) {
        checkDao.updateCheck(check);
    }

    @Override
    public Check findById(Integer checkId) {
        return checkDao.findById(checkId);
    }
}
