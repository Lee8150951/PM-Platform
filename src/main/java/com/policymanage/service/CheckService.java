package com.policymanage.service;

import com.policymanage.entity.Check;
import com.policymanage.entity.Examine;

import java.util.List;

public interface CheckService {
    /*查询所有审阅*/
    public List<Check> findAll();

    /*领导审阅*/
    public void insertCheck(Check check);

    /*查询所有未审阅的审批信息*/
    public List<Examine> findAllNoCheck();

    /*获取所有该领导未审阅信息*/
    public List<Examine> findAllNone();

    /*更新领导审阅信息*/
    public void updateCheck(Check check);

    /*通过ID查询审阅信息*/
    public Check findById(Integer checkId);
}
