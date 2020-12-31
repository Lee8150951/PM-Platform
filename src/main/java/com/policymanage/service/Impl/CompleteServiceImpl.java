package com.policymanage.service.Impl;

import com.policymanage.dao.CompleteDao;
import com.policymanage.entity.Complete;
import com.policymanage.service.CompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompleteServiceImpl implements CompleteService {
    @Autowired
    private CompleteDao completeDao;
    @Override
    public List<Complete> findAll() {
        return completeDao.findAll();
    }

    @Override
    public void insertComplete(Complete complete) {
        completeDao.insertComplete(complete);
    }

    @Override
    public Complete findById(Integer completeId) {
        return completeDao.findById(completeId);
    }
}
