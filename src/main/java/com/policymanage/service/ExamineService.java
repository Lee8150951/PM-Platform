package com.policymanage.service;

import com.policymanage.entity.Examine;
import com.policymanage.entity.Policy;

import java.util.List;

public interface ExamineService {
    /*获取所有还没有审批的企业信息*/
    public List<Policy> findExistButExa();

    /*获取所有自己未完成的审批*/
    public List<Policy> findMyExaTask(String ASSIGNEE_);

    /*查询所有已完成的审批*/
    public List<Examine> findAll();

    /*添加审批*/
    public void insertExamine(Examine examine);

    /*根据ID查询*/
    public Examine findById(Integer examineId);

    /*修改审批信息*/
    public void updateExamine(Examine examine);
}
