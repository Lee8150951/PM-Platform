package com.policymanage.service;

import com.policymanage.entity.Opinion;

import java.util.List;

public interface OpinionService {
    /*查询所有意见*/
    public List<Opinion> findAll();

    /*添加意见*/
    public void insert(Opinion opinion);

    /*删除意见*/
    public void delete(Integer opinionId);

    /*修改意见*/
    public void update(Opinion opinion);

    /*根据ID查询*/
    public Opinion findById(Integer opinionId);

    /*通过user查询*/
    public Opinion findByUser(String opinionUser);
}
