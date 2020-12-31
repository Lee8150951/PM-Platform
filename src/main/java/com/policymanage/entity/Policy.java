package com.policymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Policy implements Serializable {
    private Integer policyId;
    private String policyEnterprise;
    private String policyAddress;
    private String policyPostcode;
    private String policyBank;
    private String policyAccount;
    private String policyType;
    private String policyArea;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date policyStarttime;
    private String policyPrincipal;
    private String policyMan;
    private String policyPhone;
    private String policyGotmoney;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date policyApplytime;
    private String policyPolicy;
    private String policyContain;
    private Integer policyMoney;
    private String policyPath;

    public Integer getPolicyId() {
        return policyId;
    }

    public void setPolicyId(Integer policyId) {
        this.policyId = policyId;
    }

    public String getPolicyEnterprise() {
        return policyEnterprise;
    }

    public void setPolicyEnterprise(String policyEnterprise) {
        this.policyEnterprise = policyEnterprise;
    }

    public String getPolicyAddress() {
        return policyAddress;
    }

    public void setPolicyAddress(String policyAddress) {
        this.policyAddress = policyAddress;
    }

    public String getPolicyPostcode() {
        return policyPostcode;
    }

    public void setPolicyPostcode(String policyPostcode) {
        this.policyPostcode = policyPostcode;
    }

    public String getPolicyBank() {
        return policyBank;
    }

    public void setPolicyBank(String policyBank) {
        this.policyBank = policyBank;
    }

    public String getPolicyAccount() {
        return policyAccount;
    }

    public void setPolicyAccount(String policyAccount) {
        this.policyAccount = policyAccount;
    }

    public String getPolicyType() {
        return policyType;
    }

    public void setPolicyType(String policyType) {
        this.policyType = policyType;
    }

    public String getPolicyArea() {
        return policyArea;
    }

    public void setPolicyArea(String policyArea) {
        this.policyArea = policyArea;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getPolicyStarttime() {
        return policyStarttime;
    }

    public void setPolicyStarttime(Date policyStarttime) {
        this.policyStarttime = policyStarttime;
    }

    public String getPolicyPrincipal() {
        return policyPrincipal;
    }

    public void setPolicyPrincipal(String policyPrincipal) {
        this.policyPrincipal = policyPrincipal;
    }

    public String getPolicyMan() {
        return policyMan;
    }

    public void setPolicyMan(String policyMan) {
        this.policyMan = policyMan;
    }

    public String getPolicyPhone() {
        return policyPhone;
    }

    public void setPolicyPhone(String policyPhone) {
        this.policyPhone = policyPhone;
    }

    public String getPolicyGotmoney() {
        return policyGotmoney;
    }

    public void setPolicyGotmoney(String policyGotmoney) {
        this.policyGotmoney = policyGotmoney;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getPolicyApplytime() {
        return policyApplytime;
    }

    public void setPolicyApplytime(Date policyApplytime) {
        this.policyApplytime = policyApplytime;
    }

    public String getPolicyPolicy() {
        return policyPolicy;
    }

    public void setPolicyPolicy(String policyPolicy) {
        this.policyPolicy = policyPolicy;
    }

    public String getPolicyContain() {
        return policyContain;
    }

    public void setPolicyContain(String policyContain) {
        this.policyContain = policyContain;
    }

    public Integer getPolicyMoney() {
        return policyMoney;
    }

    public void setPolicyMoney(Integer policyMoney) {
        this.policyMoney = policyMoney;
    }

    public String getPolicyPath() {
        return policyPath;
    }

    public void setPolicyPath(String policyPath) {
        this.policyPath = policyPath;
    }

    @Override
    public String toString() {
        return "Policy{" +
                "policyId=" + policyId +
                ", policyEnterprise='" + policyEnterprise + '\'' +
                ", policyAddress='" + policyAddress + '\'' +
                ", policyPostcode='" + policyPostcode + '\'' +
                ", policyBank='" + policyBank + '\'' +
                ", policyAccount='" + policyAccount + '\'' +
                ", policyType='" + policyType + '\'' +
                ", policyArea='" + policyArea + '\'' +
                ", policyStarttime=" + policyStarttime +
                ", policyPrincipal='" + policyPrincipal + '\'' +
                ", policyMan='" + policyMan + '\'' +
                ", policyPhone='" + policyPhone + '\'' +
                ", policyGotmoney='" + policyGotmoney + '\'' +
                ", policyApplytime=" + policyApplytime +
                ", policyPolicy='" + policyPolicy + '\'' +
                ", policyContain='" + policyContain + '\'' +
                ", policyMoney=" + policyMoney +
                ", policyPath='" + policyPath + '\'' +
                '}';
    }
}
