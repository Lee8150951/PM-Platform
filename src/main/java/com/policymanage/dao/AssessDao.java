package com.policymanage.dao;

import com.policymanage.entity.Assess;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface AssessDao {
    /*查询所有*/
    @Select("select * from assess")
    @Results(id = "assessMap", value = {
            @Result(column = "a_id", property = "assessId"),
            @Result(column = "a_name", property = "assessName"),
            @Result(column = "a_boss", property = "assessBoss"),
            @Result(column = "a_signtime", property = "assessSigntime"),
            @Result(column = "a_address", property = "assessAddress"),
            @Result(column = "a_type", property = "assessType"),
            @Result(column = "a_email", property = "assessEmail"),
            @Result(column = "a_phone", property = "assessPhone"),
            @Result(column = "a_o_name", property = "assessOperateName"),
            @Result(column = "a_o_phone", property = "assessOperatePhone"),
            @Result(column = "a_o_email", property = "assessOperateEmail"),
            @Result(column = "a_o_address", property = "assessOperateAddress"),
            @Result(column = "a_time", property = "assessTime"),
            @Result(column = "a_path", property = "assessPath")
    })
    public List<Assess> findAll();

    /*添加评估信息*/
    @Insert("insert into assess(a_id, a_name, a_boss, a_signtime, a_address, a_type, a_email, a_phone, a_o_name, a_o_phone, a_o_email, a_o_address, a_time, a_path, username) values(#{assessId}, #{assessName}, #{assessBoss}, #{assessSigntime}, #{assessAddress}, #{assessType}, #{assessEmail}, #{assessPhone}, #{assessOperateName}, #{assessOperatePhone}, #{assessOperateEmail}, #{assessOperateAddress}, #{assessTime}, #{assessPath}, #{username})")
    @ResultMap(value = "assessMap")
    public void insertAssess(Assess assess);

    /*根据ID查询*/
    @Select("select * from assess where a_id = #{assessId}")
    @ResultMap(value = "assessMap")
    public Assess findById(Integer assessId);

    /*更新*/
    @Update("update assess set a_name = #{assessName}, a_boss = #{assessBoss}, a_signtime = #{assessSigntime}, a_address = #{assessAddress}, a_type = #{assessType}, a_email = #{assessEmail}, a_phone = #{assessPhone}, a_o_name = #{assessOperateName}, a_o_phone = #{assessOperatePhone}, a_o_email = #{assessOperateEmail}, a_o_address = #{assessOperateAddress}, a_time = #{assessTime}, a_path = #{assessPath} where a_id = #{assessId}")
    @ResultMap(value = "assessMap")
    public void updateAssess(Assess assess);

    /*通过ID更新评估上传附件的Path*/
    @Update("update assess set a_path = #{assessPath} where a_id = #{assessId}")
    @ResultMap(value = "assessMap")
    public void updatePathById(@Param("assessPath") String assessPath, @Param("assessId") Integer assessId);

    /*根据ID删除*/
    @Delete("delete from assess where a_id = #{assessId}")
    @ResultMap(value = "assessMap")
    public void deleteAssess(Integer assessId);

    /*根据第三方评估公司查询*/
    @Select("select * from assess where a_name like concat('%',#{assessName},'%')")
    @ResultMap(value = "assessMap")
    public List<Assess> findByName(String assessName);

    /*根据评估时间查询*/
    @Select("select * from assess where a_time = #{assessTime}")
    @ResultMap(value = "assessMap")
    public List<Assess> findByTime(Date assessTime);
}
