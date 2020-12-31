package com.test.activiti;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.DeploymentBuilder;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipInputStream;

public class testActiviti {
    /**
     * 部署流程
     */
    @Test
    public void buildProcess() {
        // 1. 获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.基于流程引擎对象获取到流程部署服务对象
        RepositoryService service = engine.getRepositoryService();
        // 3.通过service部署流程图
        DeploymentBuilder builder = service.createDeployment();
        Deployment deployment = builder.name("请假申请")
                .addClasspathResource("workflow.bpmn")
                .addClasspathResource("imgs/workflow.png")
                .deploy();
        // 4.输出流程部署对象信息
        System.out.println("流程部署成功");
        System.out.println("流程部署id：" + deployment.getId());
        System.out.println("流程部署名称：" + deployment.getName());
    }

    /**
     * 启动流程
     */
    @Test
    public void startProcess() {
        // 1.获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.通过流程引擎对象获取运行时的Service服务对象
        RuntimeService service = engine.getRuntimeService();
        // 3.通过Service启动流程，创建流程实例
        ProcessInstance instance = service.startProcessInstanceByKey("vacate");
        // 4.打印流程实例对象信息
        System.out.println("流程实例ID：" + instance.getId());
        System.out.println("流程定义ID：" + instance.getProcessInstanceId());
    }

    /**
     * 查询任务
     */
    @Test
    public void queryTask() {
        // 1.获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.通过流程引擎对象获取任务service
        TaskService service = engine.getTaskService();
        // 3.查询所有任务
        // List<Task> list = service.createTaskQuery().list();
        // 3.查询某个人的任务
        List<Task> list = service.createTaskQuery().taskAssignee("王力宏").list();
        /*由于产生了执行人，在数据库中会产生一个记录执行人的表act_ru_identitylink*/
        // 4.罗列任务信息
        for(Task task : list) {
            System.out.println("任务ID：" + task.getId());
            System.out.println("任务名称：" + task.getName());
            System.out.println("任务处理人：" + task.getAssignee());
            /*实例ID和定义ID是不同的*/
            /*实例ID是指任务所属流程实例（到底是属于张三的还是李四的）其信息包含所属人*/
            System.out.println("任务所属流程实例ID：" + task.getProcessInstanceId());
            /*定义ID区分的是什么流程（到底是请假流程还是进货流程）*/
            System.out.println("任务所属流程定义ID：" + task.getProcessDefinitionId());
        }
    }

    /**
     * 处理任务
     */
    @Test
    public void completeTask() {
        // 1.获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.通过流程引擎对象获取任务service
        TaskService service = engine.getTaskService();
        // 3.基于任务ID完成任务（默认按照先画谁走谁）
        /*此处对应的是上一个测试方法中查询到的任务ID*/
        Map<String, Object> map = new HashMap<>();
        map.put("flag", false);
        service.complete("17504", map);
        // 4.如何作出审批，选择驳回或者通过
        System.out.println("当前任务节点已经完成，将进入下一个任务节点");
    }

    /**
     * 使用上传Zip的方式部署流程
     */
    @Test
    public void buildProcessByZip() throws FileNotFoundException {
        // 1. 获取流程引擎对象
        ProcessEngine engine = ProcessEngines.getDefaultProcessEngine();
        // 2.基于流程引擎对象获取到流程部署服务对象
        RepositoryService service = engine.getRepositoryService();
        // 3.通过service部署流程图
        DeploymentBuilder builder = service.createDeployment();
        Deployment deployment = builder.name("MainFlow")
                .addZipInputStream(new ZipInputStream(new FileInputStream("C:\\Users\\61958\\Desktop\\WorkFlow.zip")))
                .deploy();
        // 4.输出流程部署对象信息
        System.out.println("流程部署成功");
        System.out.println("流程部署id：" + deployment.getId());
        System.out.println("流程部署名称：" + deployment.getName());
    }
}
