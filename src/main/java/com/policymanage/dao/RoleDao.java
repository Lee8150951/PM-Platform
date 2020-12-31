package com.policymanage.dao;

import com.policymanage.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {
    @Select("select * from t_role")
    public List<Role> findAll();

    @Select("select * from t_role where id = #{id}")
    public Role findById(Integer id);
}
