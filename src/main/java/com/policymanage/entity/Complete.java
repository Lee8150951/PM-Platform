package com.policymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Complete implements Serializable {
    private Integer completeId;
    private String completeEnterprise;
    private String completeMan;
    private String completePhone;
    private String completeType;
    private String completeAddress;
    private String completePolicy;
    private String completeMoney;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date completeStarttime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date completeComtime;
    private String completeContain;
    private String completeCondition;
    private String completeManager;
    private String completeRemark;
    private String completePath;

    public Integer getCompleteId() {
        return completeId;
    }

    public void setCompleteId(Integer completeId) {
        this.completeId = completeId;
    }

    public String getCompleteEnterprise() {
        return completeEnterprise;
    }

    public void setCompleteEnterprise(String completeEnterprise) {
        this.completeEnterprise = completeEnterprise;
    }

    public String getCompleteMan() {
        return completeMan;
    }

    public void setCompleteMan(String completeMan) {
        this.completeMan = completeMan;
    }

    public String getCompletePhone() {
        return completePhone;
    }

    public void setCompletePhone(String completePhone) {
        this.completePhone = completePhone;
    }

    public String getCompleteType() {
        return completeType;
    }

    public void setCompleteType(String completeType) {
        this.completeType = completeType;
    }

    public String getCompleteAddress() {
        return completeAddress;
    }

    public void setCompleteAddress(String completeAddress) {
        this.completeAddress = completeAddress;
    }

    public String getCompletePolicy() {
        return completePolicy;
    }

    public void setCompletePolicy(String completePolicy) {
        this.completePolicy = completePolicy;
    }

    public String getCompleteMoney() {
        return completeMoney;
    }

    public void setCompleteMoney(String completeMoney) {
        this.completeMoney = completeMoney;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCompleteStarttime() {
        return completeStarttime;
    }

    public void setCompleteStarttime(Date completeStarttime) {
        this.completeStarttime = completeStarttime;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCompleteComtime() {
        return completeComtime;
    }

    public void setCompleteComtime(Date completeComtime) {
        this.completeComtime = completeComtime;
    }

    public String getCompleteContain() {
        return completeContain;
    }

    public void setCompleteContain(String completeContain) {
        this.completeContain = completeContain;
    }

    public String getCompleteCondition() {
        return completeCondition;
    }

    public void setCompleteCondition(String completeCondition) {
        this.completeCondition = completeCondition;
    }

    public String getCompleteManager() {
        return completeManager;
    }

    public void setCompleteManager(String completeManager) {
        this.completeManager = completeManager;
    }

    public String getCompleteRemark() {
        return completeRemark;
    }

    public void setCompleteRemark(String completeRemark) {
        this.completeRemark = completeRemark;
    }

    public String getCompletePath() {
        return completePath;
    }

    public void setCompletePath(String completePath) {
        this.completePath = completePath;
    }

    @Override
    public String toString() {
        return "Complete{" +
                "completeId=" + completeId +
                ", completeEnterprise='" + completeEnterprise + '\'' +
                ", completeMan='" + completeMan + '\'' +
                ", completePhone='" + completePhone + '\'' +
                ", completeType='" + completeType + '\'' +
                ", completeAddress='" + completeAddress + '\'' +
                ", completePolicy='" + completePolicy + '\'' +
                ", completeMoney='" + completeMoney + '\'' +
                ", completeStarttime=" + completeStarttime +
                ", completeComtime=" + completeComtime +
                ", completeContain='" + completeContain + '\'' +
                ", completeCondition='" + completeCondition + '\'' +
                ", completeManager='" + completeManager + '\'' +
                ", completeRemark='" + completeRemark + '\'' +
                ", completePath='" + completePath + '\'' +
                '}';
    }
}
