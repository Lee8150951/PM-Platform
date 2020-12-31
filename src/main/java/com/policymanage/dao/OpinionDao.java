package com.policymanage.dao;

import com.policymanage.entity.Opinion;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OpinionDao {
    /*查询所有*/
    @Select("select * from opinion")
    @Results(id = "opinionMap", value = {
            @Result(column = "o_id", property = "opinionId"),
            @Result(column = "o_content", property = "opinionContent"),
            @Result(column = "o_user", property = "opinionUser")
    })
    public List<Opinion> findAll();

    /*更新意见*/
    @Update("update opinion set o_content = #{opinionContent} where o_id = #{opinionId}")
    @ResultMap(value = "opinionMap")
    public void update(Opinion opinion);

    /*删除意见*/
    @Delete("delete from opinion where o_id = #{opinionId}")
    @ResultMap(value = "opinionMap")
    public void delete(Integer opinionId);

    /*根据ID查询*/
    @Select("select * from opinion where o_id = #{opinionId}")
    @ResultMap(value = "opinionMap")
    public Opinion findById(Integer opinionId);

    /*新增意见*/
    @Insert("insert into opinion(o_content, o_user) values(#{opinionContent}, #{opinionUser})")
    @ResultMap(value = "opinionMap")
    public void insert(Opinion opinion);

    /*通过用户名查询*/
    @Select("select * from opinion where o_user = #{opinionUser}")
    @ResultMap(value = "opinionMap")
    public Opinion findByUser(String opinionUser);
}
