package com.policymanage.service;

import com.policymanage.entity.Policy;

import java.util.List;

public interface PolicyService {
    /*查询所有*/
    public List<Policy> findAll();

    /*申请政策*/
    public void insertPolicy(Policy policy);

    /*先向表中插入ID而后更新*/
    public void updateInsert(Policy policy, String username);

    /*通过ID查询*/
    public Policy findById(String policyId);

    /*通过username查询当前操作的企业是否存在一份企业政策*/
    public boolean findExist(String username);

    /*修改已填写的政策信息*/
    public void updatePolicy(Policy policy, String username);

    /*通过用户名查询对应企业ID*/
    public Integer findIdByUser(String username);
}
