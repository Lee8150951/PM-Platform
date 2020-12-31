package com.policymanage.dao;

import com.policymanage.entity.Roleapply;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleapplyDao {
    @Select("select * from roleapply")
    public List<Roleapply> findAll();

    @Select("select * from roleapply where id = #{id}")
    public Roleapply findById(Integer id);

    @Update("update roleapply set role_id = #{role_id}, opinion = #{opinion} where id = #{id}")
    public void update(Roleapply roleapply);

    @Insert("insert into roleapply(id, role_id, opinion) values(#{id}, #{role_id}, #{opinion})")
    public void insert(Roleapply roleapply);

    @Update("update roleapply set opinion = #{opinion} where id = #{id}")
    public void updateOpinion(Roleapply roleapply);
}
