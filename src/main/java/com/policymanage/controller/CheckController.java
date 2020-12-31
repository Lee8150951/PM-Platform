package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.activiti.service.ActivitiService;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.entity.Check;
import com.policymanage.entity.Examine;
import com.policymanage.service.CheckService;
import com.policymanage.service.EnterpriseService;
import com.policymanage.service.ExamineService;
import com.policymanage.service.PolicyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/check")
public class CheckController {
    @Autowired
    private CheckService checkService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private ExamineService examineService;
    @Autowired
    private PolicyService policyService;
    @Autowired
    private ActivitiService activitiService;
    @Autowired
    private ProcessService processService;

    /**
     * 获取所有待审阅项目
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
        List<Examine> examine = checkService.findAllNone();
        PageInfo<Examine> pageInfo = new PageInfo<Examine>(examine);
        model.addAttribute("pageInfo", pageInfo);
        return "CheckIndex";
    }

    /**
     * 获取所有企业，审批，申请情况
     * @param examineId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/insertCheck")
    public String insertCheck(Integer examineId, HttpServletRequest request, Model model) {
        String str = examineId.toString();
        /*保存对象数据并转发至前端进行调用*/
        model.addAttribute("enterprise", enterpriseService.findById(examineId));
        model.addAttribute("policy", policyService.findById(str));
        model.addAttribute("examine", examineService.findById(examineId));
        return "CheckAdd";
    }

    /**
     * 添加审阅信息
     * @param check
     */
    @RequestMapping("/check")
    public void check(Check check) {
        // 获取check的id，判断其是否存在
        Check i = checkService.findById(check.getCheckId());
        if (i == null) {
            // 添加审阅信息
            checkService.insertCheck(check);
        }
        else {
            // 修改审批信息
            checkService.updateCheck(check);
        }
        /*处理任务五：政策审阅*/
        Map<String, Object> variables = new HashMap<>();
        // 获取check中的审批结果，并判断分支
        String checkResult = check.getCheckResult();
        if (checkResult.equals("通过")) {
            variables.put("approve", true);
        } else {
            variables.put("approve", false);
        }
        // 获得流程ID
        String proByBUSI = processService.findProByBUSI(check.getCheckId());
        // 处理任务
        activitiService.completeTask(proByBUSI, variables);
    }
}
