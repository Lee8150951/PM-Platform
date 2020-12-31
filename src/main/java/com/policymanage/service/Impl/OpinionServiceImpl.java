package com.policymanage.service.Impl;

import com.policymanage.dao.OpinionDao;
import com.policymanage.entity.Opinion;
import com.policymanage.service.OpinionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OpinionServiceImpl implements OpinionService {
    @Autowired
    private OpinionDao opinionDao;
    @Override
    public List<Opinion> findAll() {
        return opinionDao.findAll();
    }

    @Override
    public void insert(Opinion opinion) {
        opinionDao.insert(opinion);
    }

    @Override
    public void delete(Integer opinionId) {
        opinionDao.delete(opinionId);
    }

    @Override
    public void update(Opinion opinion) {
        opinionDao.update(opinion);
    }

    @Override
    public Opinion findById(Integer opinionId) {
        return opinionDao.findById(opinionId);
    }

    @Override
    public Opinion findByUser(String opinionUser) {
        return opinionDao.findByUser(opinionUser);
    }
}
