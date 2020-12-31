package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.activiti.service.ActivitiService;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.entity.Enterprise;
import com.policymanage.entity.Examine;
import com.policymanage.entity.Policy;
import com.policymanage.service.EnterpriseService;
import com.policymanage.service.ExamineService;
import com.policymanage.service.PolicyService;
import org.apache.shiro.SecurityUtils;
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
@RequestMapping("/examine")
public class ExamineController {
    @Autowired
    private ExamineService examineService;
    @Autowired
    private PolicyService policyService;
    @Autowired
    private ProcessService processService;
    @Autowired
    private ActivitiService activitiService;
    @Autowired
    private EnterpriseService enterpriseService;

    /**
     * 跳转至ExamineIndex界面并携带所有数据进行分页
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getAllUndone")
    public String getAllUndone(ModelMap model,
            /*页码*/
                          @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                          @RequestParam(defaultValue = "5", required = true, value="ps") Integer ps
    ) {
        PageHelper.startPage(pn, ps);
        List<Policy> list = examineService.findExistButExa();
        List<Policy> policy = examineService.findExistButExa();
        PageInfo<Policy> pageInfo = new PageInfo<Policy>(policy);
        model.addAttribute("pageInfo", pageInfo);
        return "ExamineIndex";
    }

    /**
     * 跳转至ExamineMine界面并携带所有数据进行分页
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getMyUndone")
    public String getMyUndone(ModelMap model,
            /*页码*/
                          @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                          @RequestParam(defaultValue = "5", required = true, value="ps") Integer ps
    ) {
        // 获取当前用户的用户名
        String ASSIGNEE_ = (String)SecurityUtils.getSubject().getPrincipal();
        PageHelper.startPage(pn, ps);
        List<Policy> policy = examineService.findMyExaTask(ASSIGNEE_);
        PageInfo<Policy> pageInfo = new PageInfo<Policy>(policy);
        model.addAttribute("pageInfo", pageInfo);
        return "ExamineMine";
    }

    /**
     * 跳转至ExamineAll界面并携带所有数据进行分页
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getList")
    public String getList(ModelMap model,
            /*页码*/
                               @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                               @RequestParam(defaultValue = "5", required = true, value="ps") Integer ps
    ) {
        PageHelper.startPage(pn, ps);
        List<Examine> list = examineService.findAll();
        List<Examine> examine = examineService.findAll();
        PageInfo<Examine> pageInfo = new PageInfo<Examine>(examine);
        model.addAttribute("pageInfo", pageInfo);
        return "ExamineAll";
    }

    /**
     * 携带数据跳转至审批界面
     * @param policyId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/examine")
    public String examine(Integer policyId, HttpServletRequest request, Model model){
        String str = policyId.toString();
        /*保存对象数据并转发至前端进行调用*/
        model.addAttribute("enterprise", enterpriseService.findById(policyId));
        model.addAttribute("policy", policyService.findById(str));
        return "ExamineAdd";
    }

    /**
     * 审批
     * @param examine
     */
    @RequestMapping("/addExamine")
    public void addExamine(Examine examine) {
        // 获取examine的id，判断其是否存在
        Examine i = examineService.findById(examine.getExamineId());
        if (i == null) {
            // 添加审批信息
            examineService.insertExamine(examine);
        }
        else {
            // 修改审批信息
            examineService.updateExamine(examine);
        }
        /*处理任务四：政策审批*/
        Map<String, Object> variables = new HashMap<>();
        // 获取examine中的审批结果，并判断分支
        String examineResult = examine.getExamineResult();
        if (examineResult.equals("通过")) {
            variables.put("exam", true);
            variables.put("leaderId", "leader");
        } else {
            // 找到申请政策的用户
            Integer id = examine.getExamineId();
            Enterprise enterprise = enterpriseService.findById(id);
            String userName = enterprise.getUsername();
            variables.put("exam", false);
            variables.put("clerkId", userName);
        }
        // 获得流程ID
        String proByBUSI = processService.findProByBUSI(examine.getExamineId());
        // 处理任务
        activitiService.completeTask(proByBUSI, variables);
    }
}
