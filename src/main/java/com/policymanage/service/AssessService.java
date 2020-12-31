package com.policymanage.service;

import com.policymanage.entity.Assess;
import com.policymanage.entity.Enterprise;

import java.util.List;

public interface AssessService {
    /*查询所有*/
    public List<Assess> findAll();

    /*通过ID查询对应的企业信息*/
    public Enterprise findEnterpriseById(Integer assessId);

    /*添加评估信息(除上传附件地址)*/
    public void insertAssess(Assess assess);

    /*根据ID添加评估附加路径*/
    public void updatePathById(String assessPath, Integer assessId);

    /*根据ID查询*/
    public Assess findById(Integer assessId);

    /*根据ID删除*/
    public void deleteAssess(Integer assessId);

    /*更新评估信息*/
    public void updateAssess(Assess assess);

    /*根据不同情况展示不同的列表*/
    public List<Assess> queryAssess(Integer queryKind, String queryContent);

    /*时间段查询*/
    public List<Assess> queryByTimeBucket(String beginDate, String endDate);

    /*查询添加企业是否存在*/
    public boolean AddQueryEnterprise(Integer assessId);

    /*查询添加评估是否存在*/
    public boolean AddQueryAssess(Integer assessId);

    /*查询已有信息但没有评估的企业*/
    public List<Enterprise> findExistButAssess();

    /*查询我的评估任务*/
    public List<Enterprise> findMyAssess(String ASSIGNEE_);
}
