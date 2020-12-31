package com.policymanage.dao;

import com.policymanage.entity.Enterprise;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface EnterpriseDao {
    /*查询所有*/
    @Select("select * from enterprise")
    @Results(id = "enterpriseMap", value = {
            @Result(column = "e_id", property = "enterpriseId"),
            @Result(column = "e_name", property = "enterpriseName"),
            @Result(column = "e_regaddress", property = "enterpriseRegaddress"),
            @Result(column = "e_legalman", property = "enterpriseLegalman"),
            @Result(column = "e_principal", property = "enterprisePrincipal"),
            @Result(column = "e_phone", property = "enterprisePhone"),
            @Result(column = "e_email", property = "enterpriseEmail"),
            @Result(column = "e_fund", property = "enterpriseFund"),
            @Result(column = "e_type", property = "enterpriseType"),
            @Result(column = "e_signtime", property = "enterpriseSigntime"),
            @Result(column = "e_scope", property = "enterpriseScope"),
            @Result(column = "e_rank", property = "enterpriseRank"),
            @Result(column = "e_conaddress", property = "enterpriseConaddress"),
            @Result(column = "e_postcode", property = "enterprisePostcode"),
            @Result(column = "e_account", property = "enterpriseAccount"),
            @Result(column = "e_intime", property = "enterpriseIntime"),
            @Result(column = "e_path", property = "enterprisePath")
    })
    public List<Enterprise> findAll();

    /*添加企业基本信息*/
    @Insert("insert into enterprise(e_id, e_name, e_regaddress, e_legalman, e_principal, e_phone, e_email, e_fund, e_type, e_signtime, e_scope, e_rank, e_conaddress, e_postcode, e_account, e_intime, username) values(#{enterpriseId}, #{enterpriseName}, #{enterpriseRegaddress}, #{enterpriseLegalman}, #{enterprisePrincipal}, #{enterprisePhone}, #{enterpriseEmail}, #{enterpriseFund}, #{enterpriseType}, #{enterpriseSigntime}, #{enterpriseScope}, #{enterpriseRank}, #{enterpriseConaddress}, #{enterprisePostcode}, #{enterpriseAccount}, #{enterpriseIntime}, #{username})")
    @ResultMap(value = "enterpriseMap")
    public void insertEnterprise(Enterprise enterprise);

    /*根据ID查询*/
    @Select("select * from enterprise where e_id = #{enterpriseId}")
    @ResultMap(value = "enterpriseMap")
    public Enterprise findById(Integer enterpriseId);

    /*通过ID更新企业上传附件的Path*/
    @Update("update enterprise set e_path = #{enterprisePath} where e_id = #{enterpriseId}")
    @ResultMap(value = "enterpriseMap")
    public void updatePathById(@Param("enterprisePath") String enterprisePath, @Param("enterpriseId") Integer enterpriseId);

    /*更新*/
    @Update("update enterprise set e_name = #{enterpriseName}, e_regaddress = #{enterpriseRegaddress}, e_legalman = #{enterpriseLegalman}, e_principal = #{enterprisePrincipal}, e_phone = #{enterprisePhone}, e_email = #{enterpriseEmail}, e_fund = #{enterpriseFund}, e_type = #{enterpriseType}, e_signtime = #{enterpriseSigntime}, e_scope = #{enterpriseScope}, e_rank = #{enterpriseRank}, e_conaddress = #{enterpriseConaddress}, e_postcode = #{enterprisePostcode}, e_account = #{enterpriseAccount}, e_intime = #{enterpriseIntime} where e_id = #{enterpriseId}")
    @ResultMap(value = "enterpriseMap")
    public void updateEnterprise(Enterprise enterprise);

    /*根据ID删除*/
    @Delete("delete from enterprise where e_id = #{enterpriseId}")
    @ResultMap(value = "enterpriseMap")
    public void deleteEnterprise(Integer enterpriseId);

    /*根据名称查询*/
    @Select("select * from enterprise where e_name like concat('%',#{enterpriseName},'%')")
    @ResultMap(value = "enterpriseMap")
    public List<Enterprise> findByName(String enterpriseName);

    /*根据性质查询*/
    @Select("select * from enterprise where e_type = #{enterpriseType}")
    @ResultMap(value = "enterpriseMap")
    public List<Enterprise> findByType(String enterpriseType);

    /*根据责任人查询*/
    @Select("select * from enterprise where e_principal like concat('%',#{enterprisePrincipal},'%')")
    @ResultMap(value = "enterpriseMap")
    public List<Enterprise> findByPrincipal(String enterprisePrincipal);

    /*根据开户银行查询*/
    @Select("select * from enterprise where e_account like concat('%',#{enterpriseAccount},'%')")
    @ResultMap(value = "enterpriseMap")
    public List<Enterprise> findByAccount(String enterpriseAccount);

    /*根据法人查询*/
    @Select("select * from enterprise where e_legalman like concat('%',#{enterpriseLegalman},'%')")
    @ResultMap(value = "enterpriseMap")
    public List<Enterprise> findByLegalman(String enterpriseLegalman);

    /*根据等级查询*/
    @Select("select * from enterprise where e_rank = #{enterpriseRank}")
    @ResultMap(value = "enterpriseMap")
    public List<Enterprise> findByRank(String enterpriseRank);

    /*根据入驻时间查询*/
    @Select("select * from enterprise where e_intime = #{enterpriseInTime}")
    @ResultMap(value = "enterpriseMap")
    public List<Enterprise> findByInTime(Date enterpriseInTime);

    /*通过用户名查询*/
    @Select("select * from enterprise where username = #{username}")
    @ResultMap(value = "enterpriseMap")
    public Enterprise findIdByUser(String username);
}
