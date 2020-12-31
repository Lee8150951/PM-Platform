package com.policymanage.service;

import com.policymanage.entity.Complete;

import java.util.List;

public interface CompleteService {
    public List<Complete> findAll();

    public void insertComplete(Complete complete);

    public Complete findById(Integer completeId);
}
