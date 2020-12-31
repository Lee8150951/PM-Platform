package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.activiti.entity.Process;
import com.policymanage.activiti.service.ActivitiService;
import com.policymanage.activiti.service.ProcessService;
import com.policymanage.entity.Enterprise;
import com.policymanage.service.EnterpriseService;
import com.policymanage.utils.UploadUtils;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.zip.ZipInputStream;

@Controller
@RequestMapping("/process")
public class ProcessController {
    @Autowired
    private ActivitiService activitiService;
    @Autowired
    private ProcessService processService;
    @Autowired
    private EnterpriseService enterpriseService;
    /*设定上传文件位置*/
    private final static String UPLOAD_DIR= "C:\\Users\\61958\\Desktop\\PolicyManageOA\\src\\main\\webapp\\flow";

    /**
     * 上传zip并部署工作流
     * @param flowName
     * @param file
     * @return
     */
    @RequestMapping("/submitFlow")
    public String submitFlow(@RequestParam("flowName")String flowName,
                             @RequestParam("file") MultipartFile file) throws FileNotFoundException {
        // 将文件传至flow文件夹中，并返回Path值
        String path = UploadUtils.upload(UPLOAD_DIR, file);
        // 将Path值转化为绝对路径
        String absolute = UPLOAD_DIR + "\\" + path;
        // 将其转化为zip输入流
        assert path != null;
        FileInputStream fileInputStream = new FileInputStream(absolute);
        ZipInputStream zipInputStream = new ZipInputStream(fileInputStream);
        // 调用Service方法进行部署
        activitiService.buildProcess(flowName, zipInputStream);
        return "success";
    }

    /**
     * 跳转至TaskIndex界面并携带所有数据进行分页
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getAllProcess")
    public String getlist(ModelMap model,
            /*页码*/
                          @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                          @RequestParam(defaultValue = "5", required = true, value="ps") Integer ps
    ) {
        PageHelper.startPage(pn, ps);
        List<Process> process = processService.findAll();
        PageInfo<Process> pageInfo = new PageInfo<Process>(process);
        model.addAttribute("pageInfo", pageInfo);
        return "ProcessIndex";
    }

    @RequestMapping("/getMyProcess")
    public String getMyProcess(Model model) {
        // 获取当前用户的用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        // 通过用户名查询对应企业ID
        Enterprise enterprise = enterpriseService.findByUsername(username);
        // 判断是否为空
        if (enterprise == null) {
            return "MyProcessError";
        } else {
            Integer BUSINESS_KEY_ = enterprise.getEnterpriseId();
            String processName = processService.findProcessById(BUSINESS_KEY_);
            model.addAttribute("processName", processName);
            return "MyProcess";
        }
    }
}
