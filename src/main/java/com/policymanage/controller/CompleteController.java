package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.entity.Check;
import com.policymanage.entity.Complete;
import com.policymanage.entity.Enterprise;
import com.policymanage.service.CheckService;
import com.policymanage.service.CompleteService;
import com.policymanage.service.EnterpriseService;
import com.policymanage.service.FileService;
import com.policymanage.utils.DateUtils;
import com.policymanage.utils.ResponseUtils;
import com.policymanage.utils.UploadUtils;
import com.policymanage.utils.WordUtils;
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
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/complete")
public class CompleteController {
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private CompleteService completeService;
    @Autowired
    private FileService fileService;
    @Autowired
    private CheckService checkService;
    /*设定上传文件位置*/
    private final static String UPLOAD_DIR= "D:\\GraduationProject\\PmOA\\src\\main\\webapp\\upload\\complete";

    /*携带用户信息跳转至完成情况添加界面*/
    @RequestMapping("/completeAdd")
    public String completeAdd(Model model) {
        String ASSIGNEE_ = (String) SecurityUtils.getSubject().getPrincipal();
        Enterprise enterprise = enterpriseService.findByUsername(ASSIGNEE_);
        if (enterprise == null) {
            // 如果还没上传企业信息，跳转错误
            return "CompleteError_1";
        } else {
            // 获取领导审阅
            Check check = checkService.findById(enterprise.getEnterpriseId());
            if (check == null) {
                // 如果审阅没结束则跳转错误
                return "CompleteError_2";
            } else {
                // 获取对应Complete是否存在
                Complete complete = completeService.findById(enterprise.getEnterpriseId());
                if (complete == null) {
                    // 如果为空，则允许跳转
                    model.addAttribute("enterprise", enterprise);
                    return "CompleteAdd";
                } else {
                    // 如果已经存在，跳转错误
                    return "CompleteError_3";
                }
            }
        }
    }

    /**
     * 上传文件
     * @param file
     * @param userName
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadFile")
    public String uploadFileById(@RequestParam("file") MultipartFile file, @RequestParam("userName") String userName) throws Exception {
        Enterprise enterprise = enterpriseService.findByUsername(userName);
        Integer id = enterprise.getEnterpriseId();
        String url = UploadUtils.upload(UPLOAD_DIR, file);
        String truePath = UPLOAD_DIR + "\\" + url;
        // 获取列表数据
        List<String> list = WordUtils.completeWordParse(truePath);
        Complete complete = new Complete();
        complete.setCompleteId(id);
        complete.setCompleteEnterprise(list.get(0));
        complete.setCompleteMan(list.get(1));
        complete.setCompletePhone(list.get(2));
        complete.setCompleteType(list.get(3));
        complete.setCompleteAddress(list.get(4));
        complete.setCompletePolicy(list.get(5));
        complete.setCompleteMoney(list.get(6));
        String time1 = list.get(7);
        Date Starttime = DateUtils.parseStrToDate(time1);
        complete.setCompleteStarttime(Starttime);
        String time2 = list.get(8);
        Date Comtime = DateUtils.parseStrToDate(time2);
        complete.setCompleteComtime(Comtime);
        complete.setCompleteContain(list.get(9));
        complete.setCompleteCondition(list.get(10));
        complete.setCompleteManager(list.get(11));
        complete.setCompleteRemark(list.get(12));
        completeService.insertComplete(complete);
        return "redirect:getAllInfo";
    }

    /**
     * 下载上报模板
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/download")
    public void download(HttpServletRequest request, HttpServletResponse response) throws Exception {
        String filename = "企业项目完成情况表.docx";
        // 获取文件的绝对路径名称
        String path = request.getSession().getServletContext().getRealPath("model")+"\\"+filename;
        // 得到要下载的文件
        File file = new File(path);
        ResponseUtils.download(path, filename, response);
    }

    /**
     * 跳转至CompleteIndex界面并携带所有数据进行分页
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
        List<Complete> complete = completeService.findAll();
        PageHelper.startPage(pn, ps);
        List<Complete> list = new ArrayList<>();
        for (Complete i : complete) {
            Integer id = i.getCompleteId();
            com.policymanage.entity.File file = fileService.findById(id);
            if (file == null) {
                list.add(i);
            }
        }
        PageInfo<Complete> pageInfo = new PageInfo<Complete>(list);
        model.addAttribute("pageInfo", pageInfo);
        return "CompleteIndex";
    }
}
