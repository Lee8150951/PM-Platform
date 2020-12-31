package com.policymanage.service.Impl;

import com.policymanage.dao.EnterpriseDao;
import com.policymanage.dao.PolicyDao;
import com.policymanage.entity.Enterprise;
import com.policymanage.entity.Policy;
import com.policymanage.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PolicyServiceImpl implements PolicyService {
    @Autowired
    private PolicyDao policyDao;
    @Autowired
    private EnterpriseDao enterpriseDao;
    @Override
    public List<Policy> findAll() {
        return policyDao.findAll();
    }

    @Override
    public void insertPolicy(Policy policy) {
        policyDao.insertPolicy(policy);
    }

    @Override
    public void updateInsert(Policy policy, String username) {
        // 获取前端传来的username，将其转为企业ID
        Enterprise enterprise = enterpriseDao.findIdByUser(username);
        Integer id = enterprise.getEnterpriseId();
        policy.setPolicyId(id);
        // 添加评估信息
        policyDao.insertPolicy(policy);
    }

    @Override
    public Policy findById(String policyId) {
        return policyDao.selectById(policyId);
    }

    @Override
    public boolean findExist(String username) {
        // 通过userName获取企业ID
        Enterprise enterprise = enterpriseDao.findIdByUser(username);
        Integer id = enterprise.getEnterpriseId();
        // 在所有Policy中筛选其是否存在
        String str = id.toString();
        Policy policy = policyDao.selectById(str);
        if (policy == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void updatePolicy(Policy policy, String username) {
        // 通过userName获取企业ID
        Enterprise enterprise = enterpriseDao.findIdByUser(username);
        Integer id = enterprise.getEnterpriseId();
        policy.setPolicyId(id);
        System.out.println(policy);
        // 更新政策信息
        policyDao.update(policy);
    }

    @Override
    public Integer findIdByUser(String username) {
        Enterprise enterprise = enterpriseDao.findIdByUser(username);
        return enterprise.getEnterpriseId();
    }
}
