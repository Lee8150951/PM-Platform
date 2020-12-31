package com.policymanage.service.Impl;

import com.policymanage.dao.EnterpriseDao;
import com.policymanage.dao.FileDao;
import com.policymanage.entity.Enterprise;
import com.policymanage.entity.File;
import com.policymanage.service.FileService;
import com.policymanage.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class FileServiceImpl implements FileService {
    @Autowired
    private FileDao fileDao;
    @Autowired
    private EnterpriseDao enterpriseDao;

    @Override
    public List<File> findAll() {
        return fileDao.findAll();
    }

    @Override
    public Enterprise findEnterpriseById(Integer fileId) {
        return enterpriseDao.findById(fileId);
    }

    @Override
    public void insertFile(File file) {
        fileDao.insertFile(file);
    }

    @Override
    public void updatePathById(String filePath, Integer fileId) {
        fileDao.updatePathById(filePath, fileId);
    }

    @Override
    public File findById(Integer fileId) {
        return fileDao.findById(fileId);
    }

    @Override
    public void deleteFile(Integer fileId) {
        fileDao.deleteFile(fileId);
    }

    @Override
    public void updateFile(File file) {
        fileDao.updateFile(file);
    }

    @Override
    public List<File> queryFile(Integer queryKind, String queryContent) {
        List<File> list = new ArrayList<File>();
        switch (queryKind) {
            case 1:
                list = fileDao.findByDutyofficer(queryContent);
                break;
            case 2:
                list = fileDao.findByResponse(queryContent);
                break;
            case 3:
                list = fileDao.findByTitle(queryContent);
                break;
            case 4:
                try {
                    Date date = DateUtils.parseStrToDate(queryContent);
                    list = fileDao.findByTime(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                break;
        }
        return list;
    }

    @Override
    public boolean AddQueryEnterprise(Integer fileId) {
        Enterprise enterprise = enterpriseDao.findById(fileId);
        if (enterprise == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean AddQueryFile(Integer fileId) {
        File file = fileDao.findById(fileId);
        if (file == null) {
            return true;
        } else {
            return false;
        }
    }
}
