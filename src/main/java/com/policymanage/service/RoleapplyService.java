package com.policymanage.service;

import com.policymanage.entity.Roleapply;

import java.util.List;

public interface RoleapplyService {
    public List<Roleapply> findAll();

    public Roleapply findById(Integer id);

    public void update(Roleapply roleapply);

    public void insert(Roleapply roleapply);

    public void updateOpinion(Roleapply roleapply);
}
