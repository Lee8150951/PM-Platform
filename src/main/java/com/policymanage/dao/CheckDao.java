package com.policymanage.dao;

import com.policymanage.entity.Check;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CheckDao {
    @Select("select * from `check`")
    @Results(id = "checkMap", value = {
            @Result(column = "c_id", property = "checkId"),
            @Result(column = "c_time", property = "checkTime"),
            @Result(column = "c_result", property = "checkResult"),
            @Result(column = "c_remark", property = "checkRemark")
    })
    public List<Check> findAll();

    @Insert("insert into `check`(c_id, c_time, c_result, c_remark) values(#{checkId}, #{checkTime}, #{checkResult}, #{checkRemark})")
    @ResultMap(value = "checkMap")
    public void insertCheck(Check check);

    @Select("select * from `check` where c_id = #{checkId}")
    @ResultMap(value = "checkMap")
    public Check findById(Integer c_id);

    @Update("update `check` set c_time = #{checkTime}, c_result = #{checkResult}, c_remark = #{checkRemark} where c_id = #{checkId}")
    @ResultMap(value = "checkMap")
    public void updateCheck(Check check);
}
