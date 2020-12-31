package com.policymanage.activiti.service;

import java.util.Map;
import java.util.zip.ZipInputStream;

public interface ActivitiService {
    /*部署流程*/
    public void buildProcess(String flowName, ZipInputStream stream);

    /*启动流程*/
    public void startProcess(String processName, Map<String, Object> variables);

    /*查询任务*/
    public void queryTask(String userName);

    /*处理任务*/
    public void completeTask(String taskKey, Map<String, Object> variables);
}
