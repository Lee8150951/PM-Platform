package com.policymanage.service;

import com.policymanage.activiti.entity.History;
import com.policymanage.entity.Role;
import com.policymanage.entity.User;

import java.util.List;
import java.util.Set;

public interface UserService {
    /*查询所有*/
    public List<User> findAll();

    /*通过用户名查找用户*/
    public User getByUserName(String username);

    /*通过用户名查找该用户所有的角色并保存在Set集合中*/
    public Set<String> getRoles(String username);

    /*通过用户名查找该用户所有的权限并保存在Set集合中*/
    public Set<String> getPermissions(String username);

    /*注册账户*/
    public void insertUser(User user);

    /*通过id查询用户名*/
    public String findNameById(Integer id);

    /*查询所有的评估员*/
    public List<User> findAllAssess();

    /*查询所有的政府审批员*/
    public List<User> findAllExamine();

    /*通过ID查询当前用户的角色*/
    public Role findRoleByRid(User user);

    /*删除当前角色*/
    public void deleteUser(Integer id);

    /*通过ID查询*/
    public User findById(Integer id);

    /*通过用户查询已完成任务数量*/
    public Integer findDoneNum(User user);

    /*通过用户查询未完成任务数量*/
    public Integer findUnNum(User user);

    /*查询用户已完成任务*/
    public List<History> findDone(User user);

    /*通过用户名查询权限*/
    public Integer findAuthoByName(String username);

    /*更新个人信息*/
    public void update(User user);

    /*更新角色*/
    public void updateRole(User user);

    /*获取职务中文信息*/
    public String findRoleChinese(Integer roleId);

    /*获得用户群组关系*/
    public List<User> findGroup(Integer roleId);
}
