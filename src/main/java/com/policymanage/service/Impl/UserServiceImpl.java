package com.policymanage.service.Impl;

import com.policymanage.activiti.entity.History;
import com.policymanage.activiti.entity.Process;
import com.policymanage.dao.HistoryDao;
import com.policymanage.dao.ProcessDao;
import com.policymanage.dao.RoleDao;
import com.policymanage.dao.UserDao;
import com.policymanage.entity.Role;
import com.policymanage.entity.User;
import com.policymanage.service.UserService;
import org.activiti.engine.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private ProcessDao processDao;
    @Autowired
    private HistoryDao historyDao;

    @Override
    public List<User> findAll() {
        return userDao.findAll();
    }

    @Override
    public User getByUserName(String username) {
        return userDao.getByUserName(username);
    }

    @Override
    public Set<String> getRoles(String username) {
        User user = userDao.getByUserName(username);
        Integer id = user.getRoleId();
        Set<String> role = new HashSet<>();
        role.add(userDao.findRoleById(id));
        return role;
    }

    @Override
    public Set<String> getPermissions(String username) {
        return userDao.getPermissions(username);
    }

    @Override
    public void insertUser(User user) {
        userDao.InsertUser(user);
    }

    @Override
    public String findNameById(Integer id) {
        return userDao.FindNameById(id);
    }

    @Override
    public List<User> findAllAssess() {
        List<User> all = userDao.findAll();
        List<User> list = new ArrayList<>();
        for (User user : all) {
            if (user.getRoleId().equals(5)) {
                list.add(user);
            }
        }
        return list;
    }

    @Override
    public List<User> findAllExamine() {
        List<User> all = userDao.findAll();
        List<User> list = new ArrayList<>();
        for (User user : all) {
            if (user.getRoleId().equals(2)) {
                list.add(user);
            }
        }
        return list;
    }

    @Override
    public Role findRoleByRid(User user) {
        Integer roleId = user.getRoleId();
        return roleDao.findById(roleId);
    }

    @Override
    public void deleteUser(Integer id) {
        userDao.DeleteUser(id);
    }

    @Override
    public User findById(Integer id) {
        return userDao.findById(id);
    }

    @Override
    public Integer findDoneNum(User user) {
        String username = user.getUsername();
        List<History> history = userDao.findDoneNum(username);
        return history.size();
    }

    @Override
    public Integer findUnNum(User user) {
        String username = user.getUsername();
        List<Process> process = processDao.findByASSIGNEE(username);
        return process.size();
    }

    @Override
    public List<History> findDone(User user) {
        String username = user.getUsername();
        return historyDao.findByName(username);
    }

    @Override
    public Integer findAuthoByName(String username) {
        User user = userDao.getByUserName(username);
        return user.getRoleId();
    }

    @Override
    public void update(User user) {
        userDao.update(user);
    }

    @Override
    public void updateRole(User user) {
        userDao.updateRole(user);
    }

    @Override
    public String findRoleChinese(Integer roleId) {
        String role = "";
        switch (roleId) {
            case 1: role = "企业业务员";break;
            case 2: role = "政府审批人员";break;
            case 3: role = "档案局人员";break;
            case 4: role = "高新区工作人员";break;
            case 5: role = "固定资产评估员";break;
            case 6: role = "领导";break;
            case 7: role = "超管";break;
        }
        return role;
    }

    @Override
    public List<User> findGroup(Integer roleId) {
        return userDao.findGroup(roleId);
    }
}
