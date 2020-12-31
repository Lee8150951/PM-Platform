package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.entity.Roleapply;
import com.policymanage.entity.User;
import com.policymanage.service.RoleapplyService;
import com.policymanage.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/roleapply")
public class RoleapplyController {
    @Autowired
    private RoleapplyService roleapplyService;
    @Autowired
    private UserService userService;

    /**
     * 跳转至RoleapplyIndex界面并携带所有数据进行分页
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getAllInfo")
    public String getlist(ModelMap model,
            /*页码*/
                          @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                          @RequestParam(defaultValue = "5", required = true, value="ps") Integer ps
    ) {
        List<Roleapply> roleapply = roleapplyService.findAll();
        PageHelper.startPage(pn, ps);
        List<User> user = new ArrayList<>();
        for (Roleapply i :roleapply) {
            Integer id = i.getId();
            Roleapply byId = roleapplyService.findById(id);
            System.out.println(byId);
            if (byId.getOpinion() == null){
                user.add(userService.findById(id));
            }
        }
        PageInfo<User> pageInfo = new PageInfo<User>(user);
        model.addAttribute("pageInfo", pageInfo);
        return "RoleapplyIndex";
    }

    @RequestMapping("/detail")
    public String detail(Integer id, Model model) {
        User user = userService.findById(id);
        String username = user.getUsername();
        // 转换大写
        String s = username.toUpperCase();
        char c = s.charAt(0);
        // 获取申请
        Roleapply roleapply = roleapplyService.findById(id);
        Integer role_id = roleapply.getRole_id();
        model.addAttribute("user", user);
        model.addAttribute("initial", c);
        switch (role_id) {
            case 1 : model.addAttribute("role", "企业业务员");
                break;
            case 2 : model.addAttribute("role", "政府审批员");
                break;
            case 3 : model.addAttribute("role", "档案局人员");
                break;
            case 4 : model.addAttribute("role", "高新区工作人员");
                break;
            case 5 : model.addAttribute("role", "固定资产评估员");
                break;
            case 6 : model.addAttribute("role", "领导");
                break;
            case 7 : model.addAttribute("role", "超管");
                break;
        }
        return "RoleapplyDetail";
    }

    @RequestMapping("/opinion")
    public String opinion(Integer id, Integer opinion) {
        // 更新申请表
        Roleapply roleapply = new Roleapply();
        roleapply.setId(id);
        roleapply.setOpinion(opinion);
        roleapplyService.updateOpinion(roleapply);
        System.out.println(roleapply);
        // 更新角色表
        Roleapply byId = roleapplyService.findById(id);
        Integer role_id = byId.getRole_id();
        User user = new User();
        user.setId(id);
        user.setRoleId(role_id);
        System.out.println(user);
        userService.updateRole(user);
        return "RoleapplyIndex";
    }
}
