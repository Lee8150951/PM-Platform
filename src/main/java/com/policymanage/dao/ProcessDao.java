package com.policymanage.dao;

import com.policymanage.activiti.entity.Process;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProcessDao {
    /*查询所有进程*/
    @Select("select * from act_ru_task")
    public List<Process> findAll();

    /*通过责任人查询所属任务*/
    @Select("select * from act_ru_task where ASSIGNEE_ = #{ASSIGNEE_}")
    public List<Process> findByASSIGNEE(String ASSIGNEE_);

    /*获取当前流程*/
    @Select("select * from act_ru_task where ASSIGNEE_ = #{ASSIGNEE_}")
    public Process getIdByAssignee(String ASSIGNEE_);

    /*根据流程获取当前所属任务的业务Key*/
    @Select("select BUSINESS_KEY_ from act_ru_execution where ID_ = #{ID_}")
    public String getKeyByProcess(String ID_);

    /*在act_ru_execution中注入业务ID（企业信息等一众ID）*/
    @Update("update act_ru_execution set BUSINESS_KEY_=#{BUSINESS_KEY_} where ID_ = #{ID_}")
    public void updateBUSIKeyById(@Param("BUSINESS_KEY_")Integer BUSINESS_KEY_, @Param("ID_")String ID_);

    /*根据BUSINESS_KEY_反向查询*/
    @Select("select ID_ from act_ru_execution where BUSINESS_KEY_ = #{BUSINESS_KEY_}")
    public String findIdByBUSIKey(Integer BUSINESS_KEY_);

    /*根据ID_查询所属流程*/
    @Select("select ID_ from act_ru_task where PROC_INST_ID_ = #{PROC_INST_ID_}")
    public String findProById(String ID_);

    /*通过EXECUTION_ID_查询*/
    @Select("select * from act_ru_task where EXECUTION_ID_ = #{EXECUTION_ID_}")
    public Process findByEXEId(String EXECUTION_ID_);
}