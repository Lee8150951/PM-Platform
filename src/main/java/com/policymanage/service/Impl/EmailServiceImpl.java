package com.policymanage.service.Impl;

import com.policymanage.dao.EmailDao;
import com.policymanage.entity.Email;
import com.policymanage.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmailServiceImpl implements EmailService {
    @Autowired
    private EmailDao emailDao;
    @Override
    public List<Email> findBySend(String emailSend) {
        return emailDao.findBySend(emailSend);
    }

    @Override
    public List<Email> findByGet(String emailGet) {
        return emailDao.findByGet(emailGet);
    }

    @Override
    public void insert(Email email) {
        emailDao.insert(email);
    }

    @Override
    public void delete(Integer emailId) {
        emailDao.delete(emailId);
    }

    @Override
    public Email findById(Integer emailId) {
        return emailDao.findById(emailId);
    }
}
