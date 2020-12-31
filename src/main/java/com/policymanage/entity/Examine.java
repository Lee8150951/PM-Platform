package com.policymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Examine implements Serializable {
    private Integer examineId;
    private String examineEnterprise;
    private String examineMan;
    private String examinePrincipal;
    private String examinePhone;
    private String examineUnit;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date examineTime;
    private String examineResult;
    private String examineOpinion;
    private String examinePath;

    public Integer getExamineId() {
        return examineId;
    }

    public void setExamineId(Integer examineId) {
        this.examineId = examineId;
    }

    public String getExamineEnterprise() {
        return examineEnterprise;
    }

    public void setExamineEnterprise(String examineEnterprise) {
        this.examineEnterprise = examineEnterprise;
    }

    public String getExamineMan() {
        return examineMan;
    }

    public void setExamineMan(String examineMan) {
        this.examineMan = examineMan;
    }

    public String getExaminePrincipal() {
        return examinePrincipal;
    }

    public void setExaminePrincipal(String examinePrincipal) {
        this.examinePrincipal = examinePrincipal;
    }

    public String getExaminePhone() {
        return examinePhone;
    }

    public void setExaminePhone(String examinePhone) {
        this.examinePhone = examinePhone;
    }

    public String getExamineUnit() {
        return examineUnit;
    }

    public void setExamineUnit(String examineUnit) {
        this.examineUnit = examineUnit;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getExamineTime() {
        return examineTime;
    }

    public void setExamineTime(Date examineTime) {
        this.examineTime = examineTime;
    }

    public String getExamineResult() {
        return examineResult;
    }

    public void setExamineResult(String examineResult) {
        this.examineResult = examineResult;
    }

    public String getExamineOpinion() {
        return examineOpinion;
    }

    public void setExamineOpinion(String examineOpinion) {
        this.examineOpinion = examineOpinion;
    }

    public String getExaminePath() {
        return examinePath;
    }

    public void setExaminePath(String examinePath) {
        this.examinePath = examinePath;
    }

    @Override
    public String toString() {
        return "examine{" +
                "examineId=" + examineId +
                ", examineEnterprise='" + examineEnterprise + '\'' +
                ", examineMan='" + examineMan + '\'' +
                ", examinePrincipal='" + examinePrincipal + '\'' +
                ", examinePhone='" + examinePhone + '\'' +
                ", examineUnit='" + examineUnit + '\'' +
                ", examineTime=" + examineTime +
                ", examineResult='" + examineResult + '\'' +
                ", examineOpinion='" + examineOpinion + '\'' +
                ", examinePath='" + examinePath + '\'' +
                '}';
    }
}
