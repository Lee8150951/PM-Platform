package com.policymanage.service;

import com.policymanage.entity.Email;

import java.util.List;

public interface EmailService {
    /*查询发送人所有邮件*/
    public List<Email> findBySend(String emailSend);

    /*查询收件人所有邮件*/
    public List<Email> findByGet(String emailGet);

    /*发送邮件*/
    public void insert(Email email);

    /*删除邮件*/
    public void delete(Integer emailId);

    /*根据ID查询*/
    public Email findById(Integer emailId);
}
