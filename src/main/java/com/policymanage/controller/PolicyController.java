package com.policymanage.controller;

import com.policymanage.activiti.entity.Process;
import com.policymanage.activiti.service.ActivitiService;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.entity.Assess;
import com.policymanage.entity.Enterprise;
import com.policymanage.entity.Policy;
import com.policymanage.entity.User;
import com.policymanage.service.AssessService;
import com.policymanage.service.EnterpriseService;
import com.policymanage.service.PolicyService;
import com.policymanage.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/policy")
public class PolicyController {
    @Autowired
    private PolicyService policyService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private ActivitiService activitiService;
    @Autowired
    private ProcessService processService;
    @Autowired
    private UserService userService;
    @Autowired
    private AssessService assessService;

    /*点击跳转至政策申报界面*/
    @RequestMapping("/skipPolicyAdd")
    public String skipPolicyAdd(Model model) {
        // 获取当前用户的用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        // 获取当前用户的企业信息
        Enterprise enterprise = enterpriseService.findByUsername(username);
        if (enterprise == null) {
            // 还未填报企业信息
            return "PolicyError_1";
        } else {
            // 通过当前用户名对应的政策id
            Integer id = policyService.findIdByUser(username);
            String str = id.toString();
            Policy policy = policyService.findById(str);
            if (policy == null) {
                // 判断是否属于固定资产投资公司
                Integer fund = enterprise.getEnterpriseFund();
                if (fund > 5000000) {
                    // 是固定资产投资公司
                    // 判断是否存在固定资产投资评估信息
                    Assess assess = assessService.findById(id);
                    // 判断存在
                    if (assess == null) {
                        // 固定资产未完成评估
                        return "PolicyError_3";
                    } else {
                        return "PolicyAdd";
                    }
                } else {
                    // 不是固定资产投资公司
                    // 如果是首次申报政策信息，直接跳转
                    model.addAttribute("enterprise", enterprise);
                    return "PolicyAdd";
                }
            } else {
                /*如果是二次申报，判断是否为重新申报*/
                // 在任务表中查询是否存在企业用户的任务
                List<Process> list = processService.findByASSIGNEE(username);
                if (list.size() != 0) {
                    // 如果是代表驳回重新，允许跳转
                    model.addAttribute("policy", policy);
                    return "PolicyAdd";
                } else {
                    // 如果不是，代表重复申报，禁止跳转
                    return "PolicyError_2";
                }
            }
        }
    }

    /*政策申报*/
    @RequestMapping("/policyAdd")
    public String policyAdd(Policy policy,  @RequestParam("userName")String userName) {
        // 获取username，查询是否存在对应的申报政策信息
        boolean i = policyService.findExist(userName);
        // 如果不存在，则为第一次提交
        if (!i) {
            policyService.updateInsert(policy, userName);
        }
        // 如果存在，则表示第二次提交，第一次已经被驳回
        if (i){
            policyService.updatePolicy(policy, userName);
        }
        /*处理任务三：政策申报*/
        Map<String, Object> variables = new HashMap<>();
        // 获取一个随机政府审批员信息
        List<User> user = userService.findAllExamine();
        int t = new Random().nextInt(user.size());
        User sample = user.get(t);
        String examineId = sample.getUsername();
        variables.put("examineId", examineId);
        // 获得流程ID
        String proByBUSI = processService.findProByBUSI(policy.getPolicyId());
        // 处理任务
        activitiService.completeTask(proByBUSI, variables);
        return "success";
    }
}
