package com.policymanage.dao;

import com.policymanage.entity.Email;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmailDao {
    /*查询所有*/
    @Select("select * from email")
    @Results(id = "emailMap", value = {
            @Result(column = "em_id", property = "emailId"),
            @Result(column = "em_get", property = "emailGet"),
            @Result(column = "em_send", property = "emailSend"),
            @Result(column = "em_time", property = "emailTime"),
            @Result(column = "em_head", property = "emailHead"),
            @Result(column = "em_content", property = "emailContent"),
            @Result(column = "em_url", property = "emailUrl")
    })
    public List<Email> findAll();

    /*通过发件人查询*/
    @Select("select * from email where em_send = #{emailSend}")
    @ResultMap(value = "emailMap")
    public List<Email> findBySend(String emailSend);

    /*通过收件人查询*/
    @Select("select * from email where em_get = #{emailGet}")
    @ResultMap(value = "emailMap")
    public List<Email> findByGet(String emailGet);

    /*新建邮件*/
    @Insert("insert into email(em_id, em_get, em_send, em_time, em_head, em_content, em_url) values(#{emailId}, #{emailGet}, #{emailSend}, #{emailTime}, #{emailHead}, #{emailContent}, #{emailUrl})")
    @ResultMap(value = "emailMap")
    public void insert(Email email);

    /*删除邮件*/
    @Delete("delete from email where em_id = #{emailId}")
    @ResultMap(value = "emailMap")
    public void delete(Integer emailId);

    /*根据ID查询*/
    @Select("select * from email where em_id = #{emailId}")
    @ResultMap(value = "emailMap")
    public Email findById(Integer emailId);
}
