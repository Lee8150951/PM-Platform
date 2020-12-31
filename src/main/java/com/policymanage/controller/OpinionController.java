package com.policymanage.controller;

import com.policymanage.entity.Message;
import com.policymanage.entity.Opinion;
import com.policymanage.service.OpinionService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/opinion")
public class OpinionController {
    @Autowired
    private OpinionService opinionService;

    /**
     * 根据条件添加/更新数据
     * @param opinion
     */
    @RequestMapping("/opinionUpdate")
    public void opinionUpdate(Opinion opinion) {
        // 获取当前用户的用户名
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        // 查询该用户是否拥有对应快捷意见
        Opinion opinionServiceByUser = opinionService.findByUser(username);
        if (opinionServiceByUser == null) {
            opinion.setOpinionUser(username);
            opinionService.insert(opinion);
        } else {
            Integer opinionId = opinionServiceByUser.getOpinionId();
            opinion.setOpinionId(opinionId);
            opinion.setOpinionUser(username);
            opinionService.update(opinion);
        }
    }

    @ResponseBody
    @RequestMapping("/getOpinion")
    public Message getOpinion(Model model) {
        // 获取当前用户的用户名
        String username = (String)SecurityUtils.getSubject().getPrincipal();
        // 查询该用户是否拥有对应快捷意见
        Opinion opinion = opinionService.findByUser(username);
        String content = opinion.getOpinionContent();
        return new Message(content);
    }
}
