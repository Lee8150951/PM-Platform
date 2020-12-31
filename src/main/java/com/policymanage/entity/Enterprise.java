package com.policymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Enterprise implements Serializable {
    private Integer enterpriseId;
    private String enterpriseName;
    private String enterpriseRegaddress;
    private String enterpriseLegalman;
    private String enterprisePrincipal;
    private String enterprisePhone;
    private String enterpriseEmail;
    private Integer enterpriseFund;
    private String enterpriseType;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enterpriseSigntime;
    private String enterpriseScope;
    private String enterpriseRank;
    private String enterpriseConaddress;
    private String enterprisePostcode;
    private String enterpriseAccount;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date enterpriseIntime;
    private String enterprisePath;
    private String username;

    public Integer getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(Integer enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getEnterpriseRegaddress() {
        return enterpriseRegaddress;
    }

    public void setEnterpriseRegaddress(String enterpriseRegaddress) {
        this.enterpriseRegaddress = enterpriseRegaddress;
    }

    public String getEnterpriseLegalman() {
        return enterpriseLegalman;
    }

    public void setEnterpriseLegalman(String enterpriseLegalman) {
        this.enterpriseLegalman = enterpriseLegalman;
    }

    public String getEnterprisePrincipal() {
        return enterprisePrincipal;
    }

    public void setEnterprisePrincipal(String enterprisePrincipal) {
        this.enterprisePrincipal = enterprisePrincipal;
    }

    public String getEnterprisePhone() {
        return enterprisePhone;
    }

    public void setEnterprisePhone(String enterprisePhone) {
        this.enterprisePhone = enterprisePhone;
    }

    public String getEnterpriseEmail() {
        return enterpriseEmail;
    }

    public void setEnterpriseEmail(String enterpriseEmail) {
        this.enterpriseEmail = enterpriseEmail;
    }

    public Integer getEnterpriseFund() {
        return enterpriseFund;
    }

    public void setEnterpriseFund(Integer enterpriseFund) {
        this.enterpriseFund = enterpriseFund;
    }

    public String getEnterpriseType() {
        return enterpriseType;
    }

    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getEnterpriseSigntime() {
        return enterpriseSigntime;
    }

    public void setEnterpriseSigntime(Date enterpriseSigntime) {
        this.enterpriseSigntime = enterpriseSigntime;
    }

    public String getEnterpriseScope() {
        return enterpriseScope;
    }

    public void setEnterpriseScope(String enterpriseScope) {
        this.enterpriseScope = enterpriseScope;
    }

    public String getEnterpriseRank() {
        return enterpriseRank;
    }

    public void setEnterpriseRank(String enterpriseRank) {
        this.enterpriseRank = enterpriseRank;
    }

    public String getEnterpriseConaddress() {
        return enterpriseConaddress;
    }

    public void setEnterpriseConaddress(String enterpriseConaddress) {
        this.enterpriseConaddress = enterpriseConaddress;
    }

    public String getEnterprisePostcode() {
        return enterprisePostcode;
    }

    public void setEnterprisePostcode(String enterprisePostcode) {
        this.enterprisePostcode = enterprisePostcode;
    }

    public String getEnterpriseAccount() {
        return enterpriseAccount;
    }

    public void setEnterpriseAccount(String enterpriseAccount) {
        this.enterpriseAccount = enterpriseAccount;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getEnterpriseIntime() {
        return enterpriseIntime;
    }

    public void setEnterpriseIntime(Date enterpriseIntime) {
        this.enterpriseIntime = enterpriseIntime;
    }

    public String getEnterprisePath() {
        return enterprisePath;
    }

    public void setEnterprisePath(String enterprisePath) {
        this.enterprisePath = enterprisePath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "enterpriseId=" + enterpriseId +
                ", enterpriseName='" + enterpriseName + '\'' +
                ", enterpriseRegaddress='" + enterpriseRegaddress + '\'' +
                ", enterpriseLegalman='" + enterpriseLegalman + '\'' +
                ", enterprisePrincipal='" + enterprisePrincipal + '\'' +
                ", enterprisePhone='" + enterprisePhone + '\'' +
                ", enterpriseEmail='" + enterpriseEmail + '\'' +
                ", enterpriseFund=" + enterpriseFund +
                ", enterpriseType='" + enterpriseType + '\'' +
                ", enterpriseSigntime=" + enterpriseSigntime +
                ", enterpriseScope='" + enterpriseScope + '\'' +
                ", enterpriseRank='" + enterpriseRank + '\'' +
                ", enterpriseConaddress='" + enterpriseConaddress + '\'' +
                ", enterprisePostcode='" + enterprisePostcode + '\'' +
                ", enterpriseAccount='" + enterpriseAccount + '\'' +
                ", enterpriseIntime=" + enterpriseIntime +
                ", enterprisePath='" + enterprisePath + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
