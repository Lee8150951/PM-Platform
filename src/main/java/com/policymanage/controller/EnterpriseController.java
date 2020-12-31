package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.activiti.service.ActivitiService;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.entity.Enterprise;
import com.policymanage.entity.Message;
import com.policymanage.entity.User;
import com.policymanage.service.EnterpriseService;
import com.policymanage.service.UserService;
import com.policymanage.utils.FillDataInModel;
import com.policymanage.utils.ResponseUtils;
import com.policymanage.utils.UploadUtils;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

@Controller
@RequestMapping("/enterprise")
public class EnterpriseController {
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private UserService userService;
    @Autowired
    private ActivitiService activitiService;
    @Autowired
    private ProcessService processService;
    /*设定上传文件位置*/
    private final static String UPLOAD_DIR= "D:\\GraduationProject\\PmOA\\src\\main\\webapp\\upload\\enterprise";

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
        List<Enterprise> enterprise = enterpriseService.findAll();
        PageInfo<Enterprise> pageInfo = new PageInfo<Enterprise>(enterprise);
        model.addAttribute("pageInfo", pageInfo);
        return "EnterpriseIndex";
    }

    /*点击跳转至企业信息新增界面*/
    @RequestMapping("/skipEnterpriseAdd")
    public String skipEnterpriseAdd() {
        // 获取当前用户的用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        // 通过用户名查询当前用户是否为管理人员
        Integer roleId = userService.findAuthoByName(username);
        if (roleId == 4) {
            return "EnterpriseAdd";
        } else {
            Enterprise enterprise = enterpriseService.findByUsername(username);
            if (enterprise == null) {
                return "EnterpriseAdd";
            } else {
                return "EnterpriseError";
            }
        }
    }

    /*添加企业信息*/
    @ResponseBody
    @RequestMapping("/insertEnterprise")
    public Message insertEnterprise(Enterprise enterprise, @RequestParam("userName")String userName) {
        Integer id = enterprise.getEnterpriseId();
        boolean i = enterpriseService.AddQuery(id);
        if (i) {
            enterpriseService.insertEnterprise(enterprise);
            /*获取初始启动流程信息*/
            Map<String, Object> variables = new HashMap<>();
            // 获取操作用户
            variables.put("clerkId", userName);
            // 获取判断是否为固定资产投资公司
            Integer fund = enterprise.getEnterpriseFund();
            if (fund > 5000000) {
                variables.put("invest", true);
            } else {
                variables.put("invest", false);
            }
            // 调用方法，启动流程
            activitiService.startProcess("MainFlow", variables);
            /*处理任务一：提交企业信息*/
            // 将业务ID注入流程信息中
            processService.updateBUSIKeyById(enterprise.getEnterpriseId(), userName);
            // 获取当前流程ID
            String proByBUSI = processService.findProByBUSI(enterprise.getEnterpriseId());
            // 获取一个随机评估员信息
            List<User> user = userService.findAllAssess();
            int t = new Random().nextInt(user.size());
            User sample = user.get(t);
            String assessId = sample.getUsername();
            variables.put("assessId", assessId);
            // 处理任务
            activitiService.completeTask(proByBUSI, variables);
            Message msg = new Message("yes");
            return msg;
        } else {
            Message msg = new Message("no");
            return msg;
        }
    }

    /**
     * 上传文件
     * @param file
     * @param enterpriseId
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadFile")
    public String uploadFileById(@RequestParam("file") MultipartFile file,
                                 @RequestParam("enterpriseId") Integer enterpriseId) {
        String path = UploadUtils.upload(UPLOAD_DIR, file);
        enterpriseService.updatePathById(path, enterpriseId);
        return "redirect:getAllInfo";
    }

    /**
     * 详情界面传值
     * @param enterpriseId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getEnterprise")
    public String getEnterprise(Integer enterpriseId, HttpServletRequest request, Model model){
        /*保存对象数据并转发至前端进行调用*/
        Enterprise enterprise = enterpriseService.findById(enterpriseId);
        String enterpriseName = enterprise.getEnterpriseName();
        // 转换大写
        String s = enterpriseName.toUpperCase();
        char c = s.charAt(0);
        model.addAttribute("enterprise", enterprise);
        model.addAttribute("initial", c);
        return "EnterpriseDetail";
    }

    /*删除企业信息*/
    @RequestMapping("/deleteEnterprise")
    public String deleteEnterprise(Integer enterpriseId) {
        enterpriseService.deleteEnterprise(enterpriseId);
        return "redirect:getAllInfo";
    }

    /*携带数据跳转至信息修改界面*/
    @RequestMapping("/editEnterprise")
    public String editEnterprise(Enterprise enterprise, Model model){
        model.addAttribute("enterprise", enterpriseService.findById(enterprise.getEnterpriseId()));
        return "EnterpriseEdit";
    }

    /*编辑企业信息*/
    @RequestMapping("/updateEnterprise")
    public String updateEnterprise(Enterprise enterprise) {
        enterpriseService.updateEnterprise(enterprise);
        return "success";
    }

    /*根据不同情况展示不同的列表*/
    @RequestMapping("/queryEnterprise")
    public String queryEnterprise(Integer queryKind, String queryContent, ModelMap model) {
        List<Enterprise> enterprise = enterpriseService.queryEnterprise(queryKind, queryContent);
        PageInfo<Enterprise> pageInfo = new PageInfo<Enterprise>(enterprise);
        model.addAttribute("pageInfo", pageInfo);
        return "EnterpriseQuery";
    }

    /*跳转回总览页面*/
    @RequestMapping("/skipDashboard")
    public String skipDashboard(){
        return "Dashboard";
    }

    /**
     * 下载企业信息并导出
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/excelDown")
    public String excelDown(HttpServletResponse response,
                            HttpServletRequest request) throws Exception {
        /*获取Web项目根目录*/
        String path = request.getServletContext().getRealPath("/");
        /*定义模板的位置*/
        String url = path + "/model/Enterprise_model.xls";
        /*获取全部数据*/
        List<Enterprise> list = enterpriseService.findAll();
        /*将数据导入Excel模板*/
        Workbook workbook = FillDataInModel.EnterpriseDataExcel(list, url);
        ResponseUtils.export(response, workbook, "企业信息.xls");
        return null;
    }
}
