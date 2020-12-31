package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.entity.Email;
import com.policymanage.entity.Message;
import com.policymanage.entity.User;
import com.policymanage.service.EmailService;
import com.policymanage.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/email")
public class EmailController {
    @Autowired
    private EmailService emailService;
    @Autowired
    private UserService userService;

    /**
     * 跳转至EmailSend界面并携带所有数据进行分页
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getAllSend")
    public String getAllSend(ModelMap model,
            /*页码*/
                          @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                          @RequestParam(defaultValue = "10", required = true, value="ps") Integer ps
    ) {
        // 获取当前用户的用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        PageHelper.startPage(pn, ps);
        List<Email> email = emailService.findBySend(username);
        PageInfo<Email> pageInfo = new PageInfo<Email>(email);
        model.addAttribute("pageInfo", pageInfo);
        return "EmailSend";
    }

    /**
     * 跳转至EmailGet界面并携带所有数据进行分页
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getAllGet")
    public String getAllGet(ModelMap model,
            /*页码*/
                          @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                          @RequestParam(defaultValue = "10", required = true, value="ps") Integer ps
    ) {
        // 获取当前用户的用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        PageHelper.startPage(pn, ps);
        List<Email> email = emailService.findByGet(username);
        PageInfo<Email> pageInfo = new PageInfo<Email>(email);
        model.addAttribute("pageInfo", pageInfo);
        return "EmailGet";
    }

    /**
     * 邮件详情
     * @param model
     * @param emailId
     * @return
     */
    @RequestMapping("/emailDetail")
    public String emailDetail(Model model, Integer emailId) {
        Email email = emailService.findById(emailId);
        model.addAttribute("email", email);
        return "EmailDetail";
    }

    /*删除企业信息1*/
    @RequestMapping("/deleteEmailBySend")
    public String deleteEmailBySend(Integer emailId) {
        emailService.delete(emailId);
        return "redirect:getAllSend";
    }

    /*删除企业信息2*/
    @RequestMapping("/deleteEmailByGet")
    public String deleteEmailByGet(Integer emailId) {
        emailService.delete(emailId);
        return "redirect:getAllGet";
    }

    /*单发邮件*/
    @ResponseBody
    @RequestMapping("/insertEmailSingle")
    public Message insertEmailSingle(Email email, @RequestParam("carbon")String carbon) {
        // 获取当前发送者
        String emailSend = (String) SecurityUtils.getSubject().getPrincipal();
        System.out.println(carbon);
        // 判断是否需要抄送
        if (carbon.equals("")) {
            System.out.println("startNo");
            // 判断对方用户是否存在
            String emailGet = email.getEmailGet();
            System.out.println(emailGet);
            User user1 = userService.getByUserName(emailGet);
            System.out.println(user1);
            if (user1 != null) {
                // 发送一封邮件
                email.setEmailSend(emailSend);
                System.out.println("1" + email);
                emailService.insert(email);
                return new Message("success");
            } else {
                System.out.println("false");
                return new Message("false");
            }
        } else {
            System.out.println("startYes");
            // 判断对方用户是否存在
            String emailGet = email.getEmailGet();
            System.out.println(emailGet);
            User user1 = userService.getByUserName(emailGet);
            System.out.println(user1);
            User user2 = userService.getByUserName(carbon);
            System.out.println(user2);
            if (user1 != null && user2 != null) {
                /*发送第一封邮件*/
                email.setEmailSend(emailSend);
                System.out.println("2" + email);
                emailService.insert(email);
                /*发送第二封邮件*/
                Email cEmail = new Email();
                // 获取邮件内容
                cEmail.setEmailSend(emailSend);
                cEmail.setEmailGet(carbon);
                cEmail.setEmailTime(email.getEmailTime());
                cEmail.setEmailHead(email.getEmailHead());
                cEmail.setEmailContent(email.getEmailContent());
                System.out.println("3" + cEmail);
                emailService.insert(cEmail);
                return new Message("success");
            } else {
                return new Message("false");
            }
        }
    }

    /*群发邮件*/
    @ResponseBody
    @RequestMapping("/insertEmailGroup")
    public Message insertEmailGroup(Email email, @RequestParam("group")Integer group) {
        // 获取当前发送者
        String emailSend = (String) SecurityUtils.getSubject().getPrincipal();
        // 获取所有组成员
        List<User> userList = userService.findGroup(group);
        for (User user : userList) {
            String username = user.getUsername();
            email.setEmailGet(username);
            email.setEmailSend(emailSend);
            emailService.insert(email);
        }
        return new Message("success");
    }

    /*跳转发送邮件*/
    @RequestMapping("/skipToAdd")
    public String skipToAdd() {
        return "EmailAdd";
    }
}
