package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.activiti.service.ActivitiService;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.entity.Assess;
import com.policymanage.entity.Enterprise;
import com.policymanage.entity.Message;
import com.policymanage.entity.Policy;
import com.policymanage.service.AssessService;
import com.policymanage.service.EnterpriseService;
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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/assess")
public class AssessController {
    @Autowired
    private AssessService assessService;
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private ActivitiService activitiService;
    @Autowired
    private ProcessService processService;
    /*设定上传文件位置*/
    private final static String UPLOAD_DIR= "D:\\GraduationProject\\PmOA\\src\\main\\webapp\\upload\\assess";

    /**
     * 跳转至AssessIndex界面并携带所有数据进行分页
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
        List<Assess> assess = assessService.findAll();
        PageInfo<Assess> pageInfo = new PageInfo<Assess>(assess);
        model.addAttribute("pageInfo", pageInfo);
        return "AssessIndex";
    }

    /*点击跳转至评估信息新建界面*/
    @RequestMapping("/skipAssessAdd")
    public String skipAssessAdd() {
        return "AssessAdd";
    }

    /*添加评估信息*/
    @ResponseBody
    @RequestMapping("/insertAssess")
    public Message insertAssess(Assess assess, @RequestParam("userName")String userName) {
        // 添加评估信息
        assessService.insertAssess(assess);
        /*处理任务二：固定资产评估*/
        // 通过ID查询对应企业信息的用户账号
        Enterprise enterprise = enterpriseService.findById(assess.getAssessId());
        String username = enterprise.getUsername();
        // 将用户账号写入map集合注入流程
        Map<String, Object> variables = new HashMap<>();
        variables.put("clerkId", username);
        // 获得流程ID
        String proByBUSI = processService.findProByBUSI(assess.getAssessId());
        // 处理任务
        activitiService.completeTask(proByBUSI, variables);
        /*向前端传递信息*/
        Message msg = new Message("yes");
        return msg;
    }

    /**
     * 上传文件
     * @param file
     * @param assessId
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadFile")
    public String uploadFileById(@RequestParam("file") MultipartFile file, @RequestParam("assessId") Integer assessId) {
        String path = UploadUtils.upload(UPLOAD_DIR, file);
        assessService.updatePathById(path, assessId);
        return "success";
    }

    /**
     * 详情界面传值
     * @param assessId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getAssess")
    public String getFile(Integer assessId, HttpServletRequest request, Model model){
        /*保存对象数据并转发至前端进行调用*/
        model.addAttribute("assess", assessService.findById(assessId));
        model.addAttribute("enterprise", assessService.findEnterpriseById(assessId));
        return "AssessDetail";
    }

    /*删除评估信息*/
    @RequestMapping("/deleteAssess")
    public String deleteAssess(Integer assessId) {
        assessService.deleteAssess(assessId);
        return "redirect:getAllInfo";
    }

    /*携带数据跳转至信息修改界面*/
    @RequestMapping("/editAssess")
    public String editAssess(Assess assess, HttpServletRequest request, Model model){
        model.addAttribute("assess", assessService.findById(assess.getAssessId()));
        return "AssessEdit";
    }

    /*编辑评估信息*/
    @RequestMapping("/updateAssess")
    public String updateAssess(Assess assess) {
        assessService.updateAssess(assess);
        return "success";
    }

    /*根据不同情况展示不同的列表*/
    @RequestMapping("/queryAssess")
    public String queryEnterprise(Integer queryKind, String queryContent, ModelMap model) {
        List<Assess> assess = assessService.queryAssess(queryKind, queryContent);
        PageInfo<Assess> pageInfo = new PageInfo<Assess>(assess);
        model.addAttribute("pageInfo", pageInfo);
        return "AssessQuery";
    }

    /*跳转回总览页面*/
    @RequestMapping("/skipDashboard")
    public String skipDashboard(){
        return "Dashboard";
    }

    /**
     * 时间段查询评估信息
     * @param beginDate
     * @param endDate
     * @param model
     * @return
     */
    @RequestMapping("/queryByTimeBucket")
    public String queryByTimeBucket(String beginDate, String endDate, Model model) {
        List<Assess> assess = assessService.queryByTimeBucket(beginDate, endDate);
        PageInfo<Assess> pageInfo = new PageInfo<Assess>(assess);
        model.addAttribute("pageInfo", pageInfo);
        return "AssessQuery";
    }

    /**
     * 跳转至AssessToEvaluate界面并携带所有数据进行分页(待评估)
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getToEvaluate")
    public String getToEvaluate(ModelMap model,
            /*页码*/
                          @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                          @RequestParam(defaultValue = "5", required = true, value="ps") Integer ps
    ) {
        // 获取当前用户的用户名
        String ASSIGNEE_ = (String) SecurityUtils.getSubject().getPrincipal();
        PageHelper.startPage(pn, ps);
        List<Enterprise> enterprise = assessService.findMyAssess(ASSIGNEE_);
        PageInfo<Enterprise> pageInfo = new PageInfo<Enterprise>(enterprise);
        model.addAttribute("pageInfo", pageInfo);
        return "AssessToEvaluate";
    }

    /*携带数据跳转至评估界面*/
    @RequestMapping("/assessEnterprise")
    public String assessEnterprise(Enterprise enterprise, Model model){
        model.addAttribute("enterprise", enterpriseService.findById(enterprise.getEnterpriseId()));
        return "AssessAdd";
    }

    /**
     * 下载评估信息并导出
     * @param response
     * @param request
     * @return
     * @throws Exception
     */
    @RequestMapping("/excelDown")
    public String excelDown(HttpServletResponse response, HttpServletRequest request) throws Exception {
        /*获取Web项目根目录*/
        String path = request.getServletContext().getRealPath("/");
        /*定义模板的位置*/
        String url = path + "/model/Assess_model.xls";
        /*获取全部数据*/
        List<Assess> list = assessService.findAll();
        /*将数据导入Excel模板*/
        Workbook workbook = FillDataInModel.AssessDataExcel(list, url);
        ResponseUtils.export(response, workbook, "评估信息.xls");
        return null;
    }

    /**
     * 以Excel形式导出单个Assess信息
     * @param response
     * @param request
     * @param assessId
     * @return
     * @throws Exception
     */
    @RequestMapping("/singleExcelDown")
    public String singleExcelDown(HttpServletResponse response, HttpServletRequest request, Integer assessId) throws Exception {
        /*获取Web项目根目录*/
        String path = request.getServletContext().getRealPath("/");
        /*定义模板的位置*/
        String url = path + "/model/Assess_model.xls";
        /*获取单个数据*/
        Assess assess = assessService.findById(assessId);
        /*将数据导入Excel模板*/
        Workbook workbook = FillDataInModel.AssessSingleDataExcel(assess, url);
        ResponseUtils.export(response, workbook, "评估信息.xls");
        return null;
    }
}
