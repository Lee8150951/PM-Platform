package com.policymanage.dao;

import com.policymanage.entity.Complete;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface CompleteDao {
    @Select("select * from complete")
    @Results(id = "completeMap", value = {
            @Result(column = "com_id", property = "completeId"),
            @Result(column = "com_enterprise", property = "completeEnterprise"),
            @Result(column = "com_man", property = "completeMan"),
            @Result(column = "com_phone", property = "completePhone"),
            @Result(column = "com_type", property = "completeType"),
            @Result(column = "com_address", property = "completeAddress"),
            @Result(column = "com_policy", property = "completePolicy"),
            @Result(column = "com_money", property = "completeMoney"),
            @Result(column = "com_starttime", property = "completeStarttime"),
            @Result(column = "com_comtime", property = "completeComtime"),
            @Result(column = "com_comtime", property = "completeContain"),
            @Result(column = "com_condition", property = "completeCondition"),
            @Result(column = "com_manager", property = "completeManager"),
            @Result(column = "com_remark", property = "completeRemark"),
            @Result(column = "com_path", property = "completePath")
    })
    public List<Complete> findAll();

    @Insert("insert into complete(com_id, com_enterprise, com_man, com_phone, com_type, com_address, com_policy, com_money, com_starttime, com_comtime, com_contain, com_condition, com_manager, com_remark, com_path) values(#{completeId}, #{completeEnterprise}, #{completeMan}, #{completePhone}, #{completeType}, #{completeAddress}, #{completePolicy}, #{completeMoney}, #{completeStarttime}, #{completeComtime}, #{completeContain}, #{completeCondition}, #{completeManager}, #{completeRemark}, #{completePath})")
    @ResultMap(value = "completeMap")
    public void insertComplete(Complete complete);

    @Select("select * from complete where com_id = #{completeId}")
    @ResultMap(value = "completeMap")
    public Complete findById(Integer completeId);
}
