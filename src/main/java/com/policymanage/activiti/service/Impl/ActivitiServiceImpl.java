package com.policymanage.activiti.service.Impl;

import com.policymanage.activiti.service.ActivitiService;
import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

@Service
public class ActivitiServiceImpl implements ActivitiService {
    @Override
    public void buildProcess(String flowName, ZipInputStream stream) {
        // 1. 获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.基于流程引擎对象获取到流程部署服务对象
        RepositoryService service = engine.getRepositoryService();
        // 3.通过service部署流程图
        DeploymentBuilder builder = service.createDeployment();
        builder.name(flowName).addZipInputStream(stream).deploy();
    }

    @Override
    public void startProcess(String processName, Map<String, Object> variables) {
        // 1.获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.通过流程引擎对象获取运行时的Service服务对象
        RuntimeService service = engine.getRuntimeService();
        // 3.通过Service启动流程，创建流程实例
        service.startProcessInstanceByKey(processName, variables);
    }

    @Override
    public void queryTask(String userName) {
        // 1.获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.通过流程引擎对象获取任务service
        TaskService service = engine.getTaskService();
        // 3.查询某个人的任务
        List<Task> list = service.createTaskQuery().taskAssignee(userName).list();
        // 4.罗列任务信息
        for(Task task : list) {
            System.out.println("任务ID：" + task.getId());
            System.out.println("任务名称：" + task.getName());
            System.out.println("任务处理人：" + task.getAssignee());
            System.out.println("任务所属流程实例ID：" + task.getProcessInstanceId());
            System.out.println("任务所属流程定义ID：" + task.getProcessDefinitionId());
        }
    }

    @Override
    public void completeTask(String taskKey, Map<String, Object> variables) {
        // 1.获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.通过流程引擎对象获取任务service
        TaskService service = engine.getTaskService();
        // 3.基于任务ID完成任务（默认按照先画谁走谁）
        service.complete(taskKey, variables);
    }
}
