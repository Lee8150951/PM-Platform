package com.policymanage.service;

import com.policymanage.entity.Enterprise;

import java.util.List;

public interface EnterpriseService {
    /*查询所有*/
    public List<Enterprise> findAll();

    /*添加企业信息(除上传附件地址)*/
    public void insertEnterprise(Enterprise enterprise);

    /*根据ID添加企业附加路径*/
    public void updatePathById(String enterprisePath, Integer enterpriseId);

    /*根据ID查询*/
    public Enterprise findById(Integer enterpriseId);

    /*根据ID删除*/
    public void deleteEnterprise(Integer enterpriseId);

    /*根据ID编辑信息*/
    public void updateEnterprise(Enterprise enterprise);

    /*根据不同情况展示不同的列表*/
    public List<Enterprise> queryEnterprise(Integer queryKind, String queryContent);

    /*查询添加的ID是否存在*/
    public boolean AddQuery(Integer enterpriseId);

    /*通过用户名查询*/
    public Enterprise findByUsername(String username);
}
