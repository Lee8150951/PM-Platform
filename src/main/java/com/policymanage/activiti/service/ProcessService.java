package com.policymanage.activiti.service;

import com.policymanage.activiti.entity.Process;

import java.util.List;

public interface ProcessService {
    /*查询所有进程*/
    public List<Process> findAll();

    /*查询责任人所属任务*/
    public List<Process> findByASSIGNEE(String ASSIGNEE_);

    /*获取当前任务业务的Key*/
    public String getIdByAssignee(String ASSIGNEE_);

    /*在act_ru_execution中注入业务ID（企业信息等一众ID）*/
    public void updateBUSIKeyById(Integer BUSINESS_KEY_, String ID_);

    /*根据业务ID查询所属流程ID*/
    public String findProByBUSI(Integer BUSINESS_KEY_);

    /*通过企业ID查询当前所处流程*/
    public String findProcessById(Integer BUSINESS_KEY_);
}
