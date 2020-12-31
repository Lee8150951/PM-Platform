package com.policymanage.dao;

import com.policymanage.activiti.entity.History;
import com.policymanage.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface UserDao {
    /*查询所有用户*/
    @Select("select * from t_user")
    @Results(id = "userMap", value = {
            @Result(column = "role_id", property = "roleId")
    })
    public List<User> findAll();

    /*通过用户名查找用户*/
    @Select("select * from t_user where username = #{username}")
    @ResultMap(value = "userMap")
    public User getByUserName(String username);

    /*通过用户名查找该用户所有的角色并保存在Set集合中*/
    @Select("select r.rolename from t_user u,t_role r where u.role_id=r.id and u.username=#{username}")
    @ResultMap(value = "userMap")
    public Set<String> getRoles(String username);

    /*通过用户名查找该用户所有的权限并保存在Set集合中*/
    @Select("select p.permission_name from t_user u,t_role r,t_permission p where u.role_id=r.id and p.role_id=r.id and u.username=#{username}")
    @ResultMap(value = "userMap")
    public Set<String> getPermissions(String username);

    /*注册账户*/
    @Insert("insert into t_user(username, password, email) values(#{username}, #{password}, #{email})")
    @ResultMap(value = "userMap")
    public void InsertUser(User user);

    /*通过id查询用户名*/
    @Select("select username from t_user where id = #{id}")
    @ResultMap(value = "userMap")
    public String FindNameById(Integer id);

    /*根据ID删除用户*/
    @Delete("delete from t_user where id = #{id}")
    @ResultMap(value = "userMap")
    public void DeleteUser(Integer id);

    /*通过ID查询*/
    @Select("select * from t_user where id = #{id}")
    @ResultMap(value = "userMap")
    public User findById(Integer id);

    /*查询用户已完成任务*/
    @Select("select * from act_hi_actinst where ASSIGNEE_ = #{ASSIGNEE_}")
    @ResultMap(value = "userMap")
    public List<History> findDoneNum(String ASSIGNEE_);

    /*通过Roleid查询角色名*/
    @Select("select rolename from t_role where id = #{id}")
    public String findRoleById(Integer id);

    /*更新个人信息*/
    @Update("update t_user set username = #{username}, password = #{password}, email = #{email}, phone = #{phone}, unit = #{unit}, role_id = #{roleId} where id = #{id}")
    @ResultMap(value = "userMap")
    public void update(User user);

    @Update("update t_user set role_id = #{roleId} where id = #{id}")
    @ResultMap(value = "userMap")
    public void updateRole(User user);

    /*查询权限群组*/
    @Select("select * from t_user where role_id = #{roleId}")
    @ResultMap(value = "userMap")
    public List<User> findGroup(Integer roleId);
}
