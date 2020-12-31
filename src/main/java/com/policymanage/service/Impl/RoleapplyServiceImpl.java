package com.policymanage.service.Impl;

import com.policymanage.dao.RoleapplyDao;
import com.policymanage.entity.Roleapply;
import com.policymanage.service.RoleapplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleapplyServiceImpl implements RoleapplyService {
    @Autowired
    private RoleapplyDao roleapplyDao;
    @Override
    public List<Roleapply> findAll() {
        return roleapplyDao.findAll();
    }

    @Override
    public Roleapply findById(Integer id) {
        return roleapplyDao.findById(id);
    }

    @Override
    public void update(Roleapply roleapply) {
        roleapplyDao.update(roleapply);
    }

    @Override
    public void insert(Roleapply roleapply) {
        roleapplyDao.insert(roleapply);
    }

    @Override
    public void updateOpinion(Roleapply roleapply) {
        roleapplyDao.updateOpinion(roleapply);
    }
}
