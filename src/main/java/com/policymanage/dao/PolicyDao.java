package com.policymanage.dao;

import com.policymanage.entity.Policy;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PolicyDao {
    /*查询所有*/
    @Select("select * from policy")
    @Results(id = "policyMap", value = {
            @Result(column = "p_id", property = "policyId"),
            @Result(column = "p_enterprise", property = "policyEnterprise"),
            @Result(column = "p_address", property = "policyAddress"),
            @Result(column = "p_postcode", property = "policyPostcode"),
            @Result(column = "p_bank", property = "policyBank"),
            @Result(column = "p_account", property = "policyAccount"),
            @Result(column = "p_type", property = "policyType"),
            @Result(column = "p_area", property = "policyArea"),
            @Result(column = "p_starttime", property = "policyStarttime"),
            @Result(column = "p_principal", property = "policyPrincipal"),
            @Result(column = "p_man", property = "policyMan"),
            @Result(column = "p_phone", property = "policyPhone"),
            @Result(column = "p_gotmoney", property = "policyGotmoney"),
            @Result(column = "p_applytime", property = "policyApplytime"),
            @Result(column = "p_policy", property = "policyPolicy"),
            @Result(column = "p_contain", property = "policyContain"),
            @Result(column = "p_money", property = "policyMoney"),
            @Result(column = "p_path", property = "policyPath")
    })
    public List<Policy> findAll();

    /*申请政策(包含ID)*/
    @Insert("insert into policy(p_id, p_enterprise, p_address, p_postcode, p_bank, p_account, p_type, p_area, p_starttime, p_principal, p_man, p_phone, p_gotmoney, p_applytime, p_policy, p_contain, p_money, p_path) values(#{policyId}, #{policyEnterprise}, #{policyAddress}, #{policyPostcode}, #{policyBank}, #{policyAccount}, #{policyType}, #{policyArea}, #{policyStarttime}, #{policyPrincipal}, #{policyMan}, #{policyPhone}, #{policyGotmoney}, #{policyApplytime}, #{policyPolicy}, #{policyContain}, #{policyMoney}, #{policyPath})")
    @ResultMap(value = "policyMap")
    public void insertPolicy(Policy policy);

    /*申请政策(只含ID)*/
    @Insert("insert into policy(p_id) values(#{policyId})")
    @ResultMap(value = "policyMap")
    public void insertID(Integer policyId);

    /*通过ID添加企业信息(除path)*/
    @Update("update policy set p_enterprise = #{policyEnterprise}, p_address = #{policyAddress}, p_postcode = #{policyPostcode}, p_bank = #{policyBank}, p_account = #{policyAccount}, p_type = #{policyType}, p_area = #{policyArea}, p_starttime = #{policyStarttime}, p_principal = #{policyPrincipal}, p_man = #{policyMan}, p_phone = #{policyPhone}, p_gotmoney = #{policyGotmoney}, p_applytime = #{policyApplytime}, p_policy = #{policyPolicy}, p_contain = #{policyContain}, p_money = #{policyMoney} where p_id = #{policyId}")
    @ResultMap(value = "policyMap")
    public void updatePolicy(@Param("policy")Policy policy, @Param("policyId")Integer policyId);

    /*通过id查询*/
    @Select("select * from policy where p_id = #{policyId}")
    @ResultMap(value = "policyMap")
    public Policy selectById(String policyId);

    /*更新企业信息*/
    @Update("update policy set p_enterprise = #{policyEnterprise}, p_address = #{policyAddress}, p_postcode = #{policyPostcode}, p_bank = #{policyBank}, p_account = #{policyAccount}, p_type = #{policyType}, p_area = #{policyArea}, p_starttime = #{policyStarttime}, p_principal = #{policyPrincipal}, p_man = #{policyMan}, p_phone = #{policyPhone}, p_gotmoney = #{policyGotmoney}, p_applytime = #{policyApplytime}, p_policy = #{policyPolicy}, p_contain = #{policyContain}, p_money = #{policyMoney} where p_id = #{policyId}")
    @ResultMap(value = "policyMap")
    public void update(Policy policy);
}
