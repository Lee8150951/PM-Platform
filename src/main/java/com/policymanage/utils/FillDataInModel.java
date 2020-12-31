package com.policymanage.utils;

import com.policymanage.entity.*;
import com.policymanage.service.EnterpriseService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

import static com.policymanage.utils.DateUtils.DATE_FORMAT_YYYY_MM_DD;

public class FillDataInModel {
    /**
     * 将Enterprise数据注入Excel表格中
     * @param list
     * @param templateFileUrl
     * @return
     */
    public static Workbook EnterpriseDataExcel(List<Enterprise> list, String templateFileUrl) {
        Workbook workbook = null;
        try {
            /*解析Excel模板*/
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(templateFileUrl));
            /*创建HSSFWorkbook的Excel文档对象*/
            workbook = new HSSFWorkbook(fs);
            /*获取Excel模板的sheet页*/
            Sheet sheet = workbook.getSheetAt(0);
            /*从第二行开始注入数据*/
            int rowIndex = 1;
            Row row;
            for (Enterprise enterprise : list) {
                /*向第rowIndex行注入数据*/
                row = sheet.createRow(rowIndex);
                rowIndex++;
                row.createCell(0).setCellValue(enterprise.getEnterpriseId());
                row.createCell(1).setCellValue(enterprise.getEnterpriseName());
                row.createCell(2).setCellValue(enterprise.getEnterpriseRegaddress());
                row.createCell(3).setCellValue(enterprise.getEnterpriseLegalman());
                row.createCell(4).setCellValue(enterprise.getEnterprisePrincipal());
                row.createCell(5).setCellValue(enterprise.getEnterprisePhone());
                row.createCell(6).setCellValue(enterprise.getEnterpriseEmail());
                row.createCell(7).setCellValue(enterprise.getEnterpriseFund());
                row.createCell(8).setCellValue(enterprise.getEnterpriseType());
                row.createCell(9).setCellValue(DateUtils.parseDateToStr(enterprise.getEnterpriseSigntime(), DATE_FORMAT_YYYY_MM_DD));
                row.createCell(10).setCellValue(enterprise.getEnterpriseScope());
                row.createCell(11).setCellValue(enterprise.getEnterpriseRank());
                row.createCell(12).setCellValue(enterprise.getEnterpriseConaddress());
                row.createCell(13).setCellValue(enterprise.getEnterprisePostcode());
                row.createCell(14).setCellValue(enterprise.getEnterpriseAccount());
                row.createCell(15).setCellValue(DateUtils.parseDateToStr(enterprise.getEnterpriseIntime(), DATE_FORMAT_YYYY_MM_DD));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    /**
     * 将Assess数据注入Excel表格中
     * @param list
     * @param templateFileUrl
     * @return
     */
    public static Workbook AssessDataExcel(List<Assess> list, String templateFileUrl) {
        Workbook workbook = null;
        try {
            /*解析Excel模板*/
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(templateFileUrl));
            /*创建HSSFWorkbook的Excel文档对象*/
            workbook = new HSSFWorkbook(fs);
            /*获取Excel模板的sheet页*/
            Sheet sheet = workbook.getSheetAt(0);
            /*从第二行开始注入数据*/
            int rowIndex = 1;
            Row row;
            for (Assess assess : list) {
                /*向第rowIndex行注入数据*/
                row = sheet.createRow(rowIndex);
                rowIndex++;
                AssessRowSetValue(row, assess);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    /**
     * 将单个Assess信息导出为Excel
     * @param assess
     * @param templateFileUrl
     * @return
     */
    public static Workbook AssessSingleDataExcel(Assess assess, String templateFileUrl) {
        Workbook workbook = null;
        try {
            /*解析Excel模板*/
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(templateFileUrl));
            /*创建HSSFWorkbook的Excel文档对象*/
            workbook = new HSSFWorkbook(fs);
            /*获取Excel模板的sheet页*/
            Sheet sheet = workbook.getSheetAt(0);
            /*单个注入(从第二行开始)*/
            Row row = sheet.createRow(1);
            AssessRowSetValue(row, assess);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static void AssessRowSetValue(Row row, Assess assess) {
        row.createCell(0).setCellValue(assess.getAssessId());
        row.createCell(1).setCellValue(assess.getAssessName());
        row.createCell(2).setCellValue(assess.getAssessBoss());
        row.createCell(3).setCellValue(DateUtils.parseDateToStr(assess.getAssessSigntime(), DATE_FORMAT_YYYY_MM_DD));
        row.createCell(4).setCellValue(assess.getAssessAddress());
        row.createCell(5).setCellValue(assess.getAssessType());
        row.createCell(6).setCellValue(assess.getAssessEmail());
        row.createCell(7).setCellValue(assess.getAssessPhone());
        row.createCell(8).setCellValue(assess.getAssessOperateName());
        row.createCell(9).setCellValue(assess.getAssessOperatePhone());
        row.createCell(10).setCellValue(assess.getAssessOperateEmail());
        row.createCell(11).setCellValue(assess.getAssessOperateAddress());
        row.createCell(12).setCellValue(DateUtils.parseDateToStr(assess.getAssessTime(), DATE_FORMAT_YYYY_MM_DD));
    }


    public static Workbook FileExcel(Enterprise enterprise,
                                     Policy policy,
                                     Examine examine,
                                     Check check,
                                     Complete complete,
                                     String templateFileUrl) {
        Workbook workbook = null;
        try {
            /*解析Excel模板*/
            POIFSFileSystem fs = new POIFSFileSystem(new FileInputStream(templateFileUrl));
            /*创建HSSFWorkbook的Excel文档对象*/
            workbook = new HSSFWorkbook(fs);
            /*获取Excel模板的sheet页*/
            Sheet sheet = workbook.getSheetAt(0);
            /*注入企业基本信息数据*/
            common(sheet, 0, 1, enterprise.getEnterpriseId());
            common(sheet, 2, 1, enterprise.getEnterpriseName());
            common(sheet, 2, 3, enterprise.getEnterpriseRegaddress());
            common(sheet, 3, 1, enterprise.getEnterpriseLegalman());
            common(sheet, 3, 3, enterprise.getEnterprisePrincipal());
            common(sheet, 4, 1, enterprise.getEnterprisePhone());
            common(sheet, 4, 3, enterprise.getEnterpriseEmail());
            common(sheet, 5, 1, enterprise.getEnterpriseFund());
            common(sheet, 5, 3, enterprise.getEnterpriseType());
            common(sheet, 6, 1, DateUtils.parseDateToStr(enterprise.getEnterpriseSigntime(), DATE_FORMAT_YYYY_MM_DD));
            common(sheet, 6, 3, enterprise.getEnterpriseScope());
            common(sheet, 7, 1, enterprise.getEnterpriseRank());
            common(sheet, 7, 3, enterprise.getEnterpriseConaddress());
            common(sheet, 8, 1, enterprise.getEnterprisePostcode());
            common(sheet, 8, 3, DateUtils.parseDateToStr(enterprise.getEnterpriseIntime(), DATE_FORMAT_YYYY_MM_DD));
            /*注入申请信息*/
            common(sheet, 10, 1, policy.getPolicyBank());
            common(sheet, 10, 3, policy.getPolicyAccount());
            common(sheet, 11, 1, policy.getPolicyType());
            common(sheet, 11, 3, policy.getPolicyGotmoney());
            common(sheet, 12, 1, DateUtils.parseDateToStr(policy.getPolicyApplytime(), DATE_FORMAT_YYYY_MM_DD));
            common(sheet, 12, 3, policy.getPolicyArea());
            common(sheet, 13, 1, DateUtils.parseDateToStr(policy.getPolicyStarttime(), DATE_FORMAT_YYYY_MM_DD));
            common(sheet, 13, 3, policy.getPolicyPrincipal());
            common(sheet, 14, 1, policy.getPolicyPolicy());
            common(sheet, 14, 3, policy.getPolicyMoney());
            common(sheet, 16, 0, policy.getPolicyContain());
            /*注入审批信息*/
            common(sheet, 18, 1, examine.getExamineMan());
            common(sheet, 18, 3, examine.getExaminePrincipal());
            common(sheet, 19, 1, examine.getExaminePhone());
            common(sheet, 19, 3, examine.getExamineUnit());
            common(sheet, 20, 1, DateUtils.parseDateToStr(examine.getExamineTime(), DATE_FORMAT_YYYY_MM_DD));
            common(sheet, 20, 3, examine.getExamineResult());
            common(sheet, 22, 0, examine.getExamineOpinion());
            /*注入审阅信息*/
            common(sheet, 24, 1, DateUtils.parseDateToStr(check.getCheckTime(), DATE_FORMAT_YYYY_MM_DD));
            common(sheet, 24, 3, check.getCheckResult());
            common(sheet, 26, 0, check.getCheckRemark());
            /*注入完成信息*/
            common(sheet, 28, 1, DateUtils.parseDateToStr(complete.getCompleteStarttime(), DATE_FORMAT_YYYY_MM_DD));
            common(sheet, 28, 3, DateUtils.parseDateToStr(complete.getCompleteComtime(), DATE_FORMAT_YYYY_MM_DD));
            common(sheet, 29, 1, complete.getCompleteCondition());
            common(sheet, 29, 3, complete.getCompleteManager());
            common(sheet, 31, 0, complete.getCompleteContain());
            common(sheet, 33, 0, complete.getCompleteRemark());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return workbook;
    }

    public static void common(Sheet sheet, Integer row, Integer cell, String contain) {
        Cell c = sheet.getRow(row).getCell(cell);
        c.setCellValue(contain);
    }

    public static void common(Sheet sheet, Integer row, Integer cell, Integer contain) {
        Cell c = sheet.getRow(row).getCell(cell);
        c.setCellValue(contain);
    }
}
