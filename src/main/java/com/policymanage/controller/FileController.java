package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.entity.*;
import com.policymanage.service.*;
import com.policymanage.utils.FillDataInModel;
import com.policymanage.utils.ResponseUtils;
import com.policymanage.utils.UploadUtils;
import org.apache.poi.ss.usermodel.Workbook;
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
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileController {
    @Autowired
    private EnterpriseService enterpriseService;
    @Autowired
    private PolicyService policyService;
    @Autowired
    private ExamineService examineService;
    @Autowired
    private CompleteService completeService;
    @Autowired
    private CheckService checkService;
    @Autowired
    private FileService fileService;
    /*设定上传文件位置*/
    private final static String UPLOAD_DIR= "D:\\GraduationProject\\PmOA\\src\\main\\webapp\\upload\\file";

    /**
     * 跳转至归档界面
     * @param completeId
     * @param model
     * @return
     */
    @RequestMapping("/skipToAddFile")
    public String skipToAddFile(Integer completeId, Model model) {
        /*保存对象数据并转发至前端进行调用*/
        model.addAttribute("enterprise", enterpriseService.findById(completeId));
        String str = completeId.toString();
        model.addAttribute("policy", policyService.findById(str));
        model.addAttribute("examine", examineService.findById(completeId));
        model.addAttribute("complete", completeService.findById(completeId));
        return "FileAdd";
    }

    /**
     * 跳转至FileIndex界面并携带所有数据进行分页
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
        List<File> file = fileService.findAll();
        PageInfo<File> pageInfo = new PageInfo<File>(file);
        model.addAttribute("pageInfo", pageInfo);
        return "FileIndex";
    }

    /*添加档案信息*/
    @ResponseBody
    @RequestMapping("/insertFile")
    public void insertFile(File file) {
        fileService.insertFile(file);
    }

    /*导出全部档案信息*/
    @ResponseBody
    @RequestMapping("/downloadFile")
    public void downloadFile(Integer id, HttpServletResponse response, HttpServletRequest request) throws Exception {
        String str = id.toString();
        Enterprise enterprise = enterpriseService.findById(id);
        Examine examine = examineService.findById(id);
        Policy policy = policyService.findById(str);
        Check check = checkService.findById(id);
        Complete complete = completeService.findById(id);
        /*获取Web项目根目录*/
        String path = request.getServletContext().getRealPath("\\");
        /*定义模板的位置*/
        String url = path + "\\model\\File.xls";
        Workbook workbook = FillDataInModel.FileExcel(enterprise, policy, examine, check, complete, url);
        ResponseUtils.export(response, workbook, "档案信息.xls");
    }

    /**
     * 上传文件
     * @param file
     * @param fileId
     * @return
     */
    @ResponseBody
    @RequestMapping("/uploadFile")
    public String uploadFileById(@RequestParam("file") MultipartFile file, @RequestParam("fileId") Integer fileId) {
        String path = UploadUtils.upload(UPLOAD_DIR, file);
        fileService.updatePathById(path, fileId);
        return "success";
    }

    /**
     * 详情界面传值
     * @param fileId
     * @param request
     * @param model
     * @return
     */
    @RequestMapping("/getFile")
    public String getFile(Integer fileId, HttpServletRequest request, Model model){
        /*保存对象数据并转发至前端进行调用*/
        model.addAttribute("file", fileService.findById(fileId));
        model.addAttribute("enterprise", fileService.findEnterpriseById(fileId));
        return "FileDetail";
    }

    /*删除档案信息*/
    @RequestMapping("/deleteFile")
    public String deleteFile(Integer fileId) {
        fileService.deleteFile(fileId);
        return "redirect:getAllInfo";
    }

    /*携带数据跳转至信息修改界面*/
    @RequestMapping("/editFile")
    public String editFile(File file, HttpServletRequest request, Model model){
        Integer id = file.getFileId();
        /*保存对象数据并转发至前端进行调用*/
        model.addAttribute("enterprise", enterpriseService.findById(id));
        String str = id.toString();
        model.addAttribute("policy", policyService.findById(str));
        model.addAttribute("examine", examineService.findById(id));
        model.addAttribute("complete", completeService.findById(id));
        model.addAttribute("file", fileService.findById(id));
        return "FileEdit";
    }

    /*编辑档案信息*/
    @RequestMapping("/updateFile")
    public String updateFile(File file) {
        fileService.updateFile(file);
        return "success";
    }

    /*根据不同情况展示不同的列表*/
    @RequestMapping("/queryFile")
    public String queryEnterprise(Integer queryKind, String queryContent, ModelMap model) {
        List<File> file = fileService.queryFile(queryKind, queryContent);
        PageInfo<File> pageInfo = new PageInfo<File>(file);
        model.addAttribute("pageInfo", pageInfo);
        return "FileQuery";
    }

    /*跳转回总览页面*/
    @RequestMapping("/skipDashboard")
    public String skipDashboard(){
        return "Dashboard";
    }

    /**
     * 下载档案附件
     * @param fileId
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping("/download")
    public void download(Integer fileId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 通过fileID查询当前附件路径
        File FileById = fileService.findById(fileId);
        String filePath = FileById.getFilePath();
        // 获取文件的绝对路径名称
        String path = UPLOAD_DIR + "\\" + filePath;
        // 获取后缀名
        String suffix = filePath.substring(filePath.lastIndexOf(".") + 1);
        String filename = "档案." + suffix;
        ResponseUtils.download(path, filename, response);
    }
}
