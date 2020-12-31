package com.policymanage.service.Impl;

import com.policymanage.dao.EnterpriseDao;
import com.policymanage.entity.Enterprise;
import com.policymanage.service.EnterpriseService;
import com.policymanage.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class EnterpriseServiceImpl implements EnterpriseService {
    @Autowired
    private EnterpriseDao enterpriseDao;

    @Override
    public List<Enterprise> findAll() {
        return enterpriseDao.findAll();
    }

    @Override
    public void insertEnterprise(Enterprise enterprise) {
        enterpriseDao.insertEnterprise(enterprise);
    }

    @Override
    public void updatePathById(String enterprisePath, Integer enterpriseId) {
        enterpriseDao.updatePathById(enterprisePath, enterpriseId);
    }

    @Override
    public Enterprise findById(Integer enterpriseId) {
        return enterpriseDao.findById(enterpriseId);
    }

    @Override
    public void deleteEnterprise(Integer enterpriseId) {
        enterpriseDao.deleteEnterprise(enterpriseId);
    }

    @Override
    public void updateEnterprise(Enterprise enterprise) {
        enterpriseDao.updateEnterprise(enterprise);
    }

    @Override
    public List<Enterprise> queryEnterprise(Integer queryKind, String queryContent) {
        List<Enterprise> list = new ArrayList<Enterprise>();
        switch (queryKind) {
            case 1:
                list = enterpriseDao.findByName(queryContent);
                break;
            case 2:
                list = enterpriseDao.findByType(queryContent);
                break;
            case 3:
                list = enterpriseDao.findByPrincipal(queryContent);
                break;
            case 4:
                list = enterpriseDao.findByAccount(queryContent);
                break;
            case 5:
                list = enterpriseDao.findByLegalman(queryContent);
                break;
            case 6:
                list = enterpriseDao.findByRank(queryContent);
                break;
            case 7:
                try {
                    Date date = DateUtils.parseStrToDate(queryContent);
                    list = enterpriseDao.findByInTime(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
        }
        return list;
    }

    @Override
    public boolean AddQuery(Integer enterpriseId) {
        Enterprise enterprise = enterpriseDao.findById(enterpriseId);
        if (enterprise == null) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public Enterprise findByUsername(String username) {
        return enterpriseDao.findIdByUser(username);
    }
}
