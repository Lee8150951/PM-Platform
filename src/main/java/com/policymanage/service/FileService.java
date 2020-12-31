package com.policymanage.service;

import com.policymanage.entity.Enterprise;
import com.policymanage.entity.File;

import java.util.List;

public interface FileService {
    /*查询所有*/
    public List<File> findAll();

    /*通过ID查询对应的企业信息*/
    public Enterprise findEnterpriseById(Integer fileId);

    /*添加评估信息(除上传附件地址)*/
    public void insertFile(File file);

    /*根据ID添加评估附加路径*/
    public void updatePathById(String filePath, Integer fileId);

    /*根据ID查询*/
    public File findById(Integer fileId);

    /*根据ID删除*/
    public void deleteFile(Integer fileId);

    /*更新档案信息*/
    public void updateFile(File file);

    /*根据不同情况展示不同的列表*/
    public List<File> queryFile(Integer queryKind, String queryContent);

    /*查询添加企业是否存在*/
    public boolean AddQueryEnterprise(Integer fileId);

    /*查询添加参数信息是否存在*/
    public boolean AddQueryFile(Integer fileId);
}
