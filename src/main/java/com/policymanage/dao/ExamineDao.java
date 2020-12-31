package com.policymanage.dao;

import com.policymanage.entity.Examine;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExamineDao {
    @Select("select * from examine")
    @Results(id = "examineMap", value = {
            @Result(column = "ex_id", property = "examineId"),
            @Result(column = "ex_enterprise", property = "examineEnterprise"),
            @Result(column = "ex_man", property = "examineMan"),
            @Result(column = "ex_principal", property = "examinePrincipal"),
            @Result(column = "ex_phone", property = "examinePhone"),
            @Result(column = "ex_unit", property = "examineUnit"),
            @Result(column = "ex_time", property = "examineTime"),
            @Result(column = "ex_result", property = "examineResult"),
            @Result(column = "ex_opinion", property = "examineOpinion"),
            @Result(column = "ex_path", property = "examinePath")
    })
    public List<Examine> findAll();

    @Select("select * from examine where ex_id = #{examineId}")
    @ResultMap(value = "examineMap")
    public Examine findById(Integer examineId);

    @Select("select * from examine where ex_enterprise = #{examineEnterprise}")
    @ResultMap(value = "examineMap")
    public Examine findByEnterprise(String examineEnterprise);

    @Insert("insert examine(ex_id, ex_enterprise, ex_man, ex_principal, ex_phone, ex_unit, ex_time, ex_result, ex_opinion, ex_path) values(#{examineId}, #{examineEnterprise}, #{examineMan}, #{examinePrincipal}, #{examinePhone}, #{examineUnit}, #{examineTime}, #{examineResult}, #{examineOpinion}, #{examinePath})")
    @ResultMap(value = "examineMap")
    public void insertExamine(Examine examine);

    @Update("update examine set ex_enterprise = #{examineEnterprise}, ex_man = #{examineMan}, ex_principal = #{examinePrincipal}, ex_phone = #{examinePhone}, ex_unit = #{examineUnit}, ex_time = #{examineTime}, ex_result = #{examineResult}, ex_opinion = #{examineOpinion} where ex_id = #{examineId}")
    @ResultMap(value = "examineMap")
    public void updateExamine(Examine examine);
}
