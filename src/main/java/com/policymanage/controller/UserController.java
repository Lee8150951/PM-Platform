package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.activiti.entity.History;
import com.policymanage.activiti.entity.Process;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.entity.*;
import com.policymanage.service.*;
import org.activiti.engine.impl.util.json.JSONObject;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private ProcessService processService;
    @Autowired
    private RoleapplyService roleapplyService;
    @Autowired
    private OpinionService opinionService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private CompleteService completeService;
    @Autowired
    private PolicyService policyService;

    @ResponseBody
    @RequestMapping("/login")
    public Message login(User user, HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            // 获取当前用户
            Subject subject = SecurityUtils.getSubject();
            UsernamePasswordToken token = new UsernamePasswordToken(user.getUsername(), user.getPassword());
            // 认证账户
            subject.login(token);
            request.setAttribute("user", user);
            // 获取用户id
            User byUserName = userService.getByUserName(user.getUsername());
            // 通过用户ID查询对应角色申请
            Roleapply roleapply = roleapplyService.findById(byUserName.getId());
            Integer opinion = roleapply.getOpinion();
            if (opinion == null) {
                // 角色审批缺失或没有申请审批
                return new Message("deficiency");
            } else {
                // 登陆成功
                return new Message("success");
            }
        } catch (IncorrectCredentialsException e) {
            // 密码错误异常
            return new Message("false");
        }
    }

    /*跳转至权限申请界面*/
    @RequestMapping("/permissionApply")
    public String permissionApply(Model model) {
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        String str = username.toUpperCase();
        char c = str.charAt(0);
        User user = userService.getByUserName(username);
        model.addAttribute("user", user);
        model.addAttribute("initial", c);
        return "PermissionApply";
    }

    /*点击跳转至注册界面*/
    @RequestMapping("/skipRegister")
    public String skipRegister() {
        return "Register";
    }

    /*点击跳转至登录界面*/
    @RequestMapping("/skipLogin")
    public void skipLogin(HttpServletRequest request, HttpServletResponse response) throws IOException {
        /*重定向*/
        response.sendRedirect(request.getContextPath() + "/index.jsp");
    }

    /*注册账号*/
    @ResponseBody
    @RequestMapping("/register")
    public Message Register(User user) {
        // 获取用户名判断是否已被注册
        String username = user.getUsername();
        User byUserName = userService.getByUserName(username);
        if (byUserName == null) {
            userService.insertUser(user);
            // 通过用户名查询对应id
            User service = userService.getByUserName(username);
            Integer id = service.getId();
            // 在roleapply中自动生成ID对应单位
            Roleapply roleapply = new Roleapply();
            roleapply.setId(id);
            roleapplyService.insert(roleapply);
            return new Message("success");
        } else {
            return new Message("false");
        }
    }

    /*跳转至主页*/
    @RequestMapping("/dashboard")
    public String Dashboard() {
        return "Dashboard";
    }

    /**
     * 跳转至EnterpriseIndex界面并携带所有数据进行分页
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
        PageHelper.startPage(pn, ps);
        List<User> user = userService.findAll();
        PageInfo<User> pageInfo = new PageInfo<User>(user);
        model.addAttribute("pageInfo", pageInfo);
        return "UserIndex";
    }

    /*删除用户*/
    @RequestMapping("/deleteUser")
    public String deleteUser(Integer id) {
        userService.deleteUser(id);
        return "redirect:getAllInfo";
    }

    /*携带数据跳转至个人信息界面*/
    @RequestMapping("/userDetail")
    public String editEnterprise(Integer id, Model model){
        User user = userService.findById(id);
        String username = user.getUsername();
        // 转换大写
        String s = username.toUpperCase();
        char c = s.charAt(0);
        // 获取已完成任务数量
        Integer DoneNum = userService.findDoneNum(user);
        // 获取待完成任务数量
        Integer UnNum = userService.findUnNum(user);
        // 获取职务
        Integer roleId = user.getRoleId();
        String role = userService.findRoleChinese(roleId);
        // 查询用户未完成任务
        List<Process> process = processService.findByASSIGNEE(username);
        PageInfo<Process> pageInfo_p = new PageInfo<Process>(process);
        // 查询用户已完成任务
        List<History> history = userService.findDone(user);
        PageInfo<History> pageInfo_h = new PageInfo<History>(history);
        // 已完成任务
        model.addAttribute("user", userService.findById(id));
        model.addAttribute("initial", c);
        // 已完成任务数量
        model.addAttribute("DoneNum", DoneNum);
        // 待完成任务数量
        model.addAttribute("UnNum", UnNum);
        // 职务
        model.addAttribute("role", role);
        // 未完成任务
        model.addAttribute("pageInfo_p", pageInfo_p);
        // 已完成任务
        model.addAttribute("pageInfo_h", pageInfo_h);
        return "UserProfile";
    }

    /*修改用户信息*/
    @RequestMapping("/updateUser")
    public void updateUser(User user) {
        userService.update(user);
    }

    /*申请角色*/
    @ResponseBody
    @RequestMapping("/apply")
    public Message apply(User user, @RequestParam("role_id")Integer role_id) {
        // 查询是否已存在申请
        Integer id = user.getId();
        Roleapply apply = roleapplyService.findById(id);
        if (apply.getRole_id() == null) {
            userService.update(user);
            Roleapply roleapply = new Roleapply();
            roleapply.setId(user.getId());
            roleapply.setRole_id(role_id);
            roleapplyService.update(roleapply);
            return new Message("success");
        } else {
            return new Message("false");
        }
    }

    // 携带用户信息跳转至信息编辑界面
    @RequestMapping("/editProfile")
    public String editProfile(Model model) {
        // 获取操作用户
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        User user = userService.getByUserName(username);
        model.addAttribute("user", user);
        // 获取大写
        String str = username.toUpperCase();
        char c = str.charAt(0);
        model.addAttribute("initial", c);
        // 获取职务
        Integer roleId = user.getRoleId();
        String role = userService.findRoleChinese(roleId);
        model.addAttribute("role", role);
        // 查询用户未完成任务
        List<Process> process = processService.findByASSIGNEE(username);
        PageInfo<Process> pageInfo_p = new PageInfo<Process>(process);
        model.addAttribute("pageInfo_p", pageInfo_p);
        // 查询用户已完成任务
        List<History> history = userService.findDone(user);
        PageInfo<History> pageInfo_h = new PageInfo<History>(history);
        model.addAttribute("pageInfo_h", pageInfo_h);
        // 根据用户名查询快捷意见
        Opinion opinion = opinionService.findByUser(username);
        model.addAttribute("opinion", opinion);
        return "ProfileEdit";
    }

    @ResponseBody
    @RequestMapping("/getCount")
    public void getCount(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        List<Integer> listCont = new ArrayList<>();
        List<String> listName = new ArrayList<>();
        // 获取所有企业信息
        List<Enterprise> list = enterpriseService.findAll();
        // 遍历所有企业信息获取其分类以及分类数量
        int count1=0,count2=0,count3=0,count4=0,count5=0, count6=0, count7=0, count8=0, count9=0;
        for (Enterprise enterprise : list) {
            String type = enterprise.getEnterpriseType();
            switch (type) {
                case "合资企业": count1++;break;
                case "独资企业": count2++;break;
                case "国有企业": count3++;break;
                case "私营企业": count4++;break;
                case "全民所有制企业": count5++;break;
                case "集体所有制企业": count6++;break;
                case "股份制企业": count7++;break;
                case "有限责任企业": count8++;break;
                case "外资企业": count9++;break;
            }
        }
        // 将数量添加至listCont
        listCont.add(count1);listCont.add(count2);listCont.add(count3);
        listCont.add(count4);listCont.add(count5);listCont.add(count6);
        listCont.add(count7);listCont.add(count8);listCont.add(count9);
        // 将名称添加至listName
        listName.add("合资企业");listName.add("独资企业");listName.add("国有企业");
        listName.add("私营企业");listName.add("全民所有制企业");listName.add("集体所有制企业");
        listName.add("股份制企业");listName.add("有限责任企业");listName.add("外资企业");
        // 将List写入json并输出
        PrintWriter out=response.getWriter();
        JSONObject jsonData=new JSONObject();
        jsonData.put("listCont",listCont);
        jsonData.put("listName",listName);
        out.println(jsonData);
        // 将输出流缓冲区的数据送出
        out.flush();
        // 关闭输出流
        out.close();
    }

    @ResponseBody
    @RequestMapping("/getScope")
    public void getScope(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        List<Integer> listCont = new ArrayList<>();
        List<String> listName = new ArrayList<>();
        // 获取所有企业信息
        List<Enterprise> list = enterpriseService.findAll();
        // 遍历所有企业信息获取其分类以及分类数量
        int count1=0,count2=0,count3=0,count4=0,count5=0, count6=0, count7=0, count8=0, count9=0, count10=0;
        for (Enterprise enterprise : list) {
            String type = enterprise.getEnterpriseScope();
            switch (type) {
                case "互联网": count1++;break;
                case "医疗": count2++;break;
                case "文娱": count3++;break;
                case "餐饮": count4++;break;
                case "金融": count5++;break;
                case "商贸": count6++;break;
                case "建筑": count7++;break;
                case "旅游": count8++;break;
                case "教育": count9++;break;
                case "其他": count10++;break;
            }
        }
        // 将数量添加至listCont
        listCont.add(count1);listCont.add(count2);listCont.add(count3);
        listCont.add(count4);listCont.add(count5);listCont.add(count6);
        listCont.add(count7);listCont.add(count8);listCont.add(count9);listCont.add(count10);
        // 将名称添加至listName
        listName.add("互联网");listName.add("医疗");listName.add("文娱");
        listName.add("餐饮");listName.add("金融");listName.add("商贸");
        listName.add("建筑");listName.add("旅游");listName.add("教育");listName.add("其他");
        // 将List写入json并输出
        PrintWriter out=response.getWriter();
        JSONObject jsonData=new JSONObject();
        jsonData.put("listCont",listCont);
        jsonData.put("listName",listName);
        out.println(jsonData);
        // 将输出流缓冲区的数据送出
        out.flush();
        // 关闭输出流
        out.close();
    }

    /**
     * 存储数据进行映射
     * @param model
     * @return
     */
    @ResponseBody
    @RequestMapping("/storeSession")
    public Message storeSession(Model model) {
        // 查询企业信息
        List<Enterprise> list_1 = enterpriseService.findAll();
        // 企业总数
        int equality = list_1.size();
        String data_1 = Integer.toString(equality);
        // 已完成企业信息
        List<Complete> list_2 = completeService.findAll();
        int cquality = list_2.size();
        String data_2 = Integer.toString(cquality);
        // 获取总扶持金额
        List<Policy> list_3 = policyService.findAll();
        int money = 0;
        for (Policy policy : list_3) {
            System.out.println(policy);
            Integer policyMoney = policy.getPolicyMoney();
            money = money + policyMoney;
        }
        String data_3 = Integer.toString(money);
        // 获取正在审批的企业
        List<Process> list_4 = processService.findAll();
        int tquality = list_4.size();
        String data_4 = Integer.toString(tquality);
        return new Message("success", data_1, data_2, data_3, data_4);
    }

    @ResponseBody
    @RequestMapping("/getRank")
    public void getRank(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        List<Integer> listCont = new ArrayList<>();
        List<String> listName = new ArrayList<>();
        // 获取所有企业信息
        List<Enterprise> list = enterpriseService.findAll();
        // 遍历所有企业信息获取其分类以及分类数量
        int count1=0,count2=0,count3=0,count4=0,count5=0, count6=0, count7=0;
        for (Enterprise enterprise : list) {
            String rank = enterprise.getEnterpriseRank();
            switch (rank) {
                case "AAA级": count1++;break;
                case "AA级": count2++;break;
                case "A级": count3++;break;
                case "BBB级": count4++;break;
                case "BB级": count5++;break;
                case "B级": count6++;break;
                case "C级": count7++;break;
            }
        }
        // 将数量添加至listCont
        listCont.add(count1);listCont.add(count2);listCont.add(count3);
        listCont.add(count4);listCont.add(count5);listCont.add(count6);
        listCont.add(count7);
        // 将名称添加至listName
        listName.add("AAA级");listName.add("AA级");listName.add("A级");
        listName.add("BBB级");listName.add("BB级");listName.add("B级");
        listName.add("C级");
        // 将List写入json并输出
        PrintWriter out=response.getWriter();
        JSONObject jsonData=new JSONObject();
        jsonData.put("listCont",listCont);
        jsonData.put("listName",listName);
        out.println(jsonData);
        // 将输出流缓冲区的数据送出
        out.flush();
        // 关闭输出流
        out.close();
    }

    @ResponseBody
    @RequestMapping("/getAll")
    public void getNum(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");
        // 获取所有企业信息
        List<Enterprise> list = enterpriseService.findAll();
        // 将List写入json并输出
        PrintWriter out=response.getWriter();
        JSONObject jsonData=new JSONObject();
        jsonData.put("list",list);
        out.println(jsonData);
        // 将输出流缓冲区的数据送出
        out.flush();
        // 关闭输出流
        out.close();
    }
}