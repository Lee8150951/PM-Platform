package com.policymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Assess implements Serializable {
    private Integer assessId;
    private String assessName;
    private String assessBoss;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date assessSigntime;
    private String assessAddress;
    private String assessType;
    private String assessEmail;
    private String assessPhone;
    private String assessOperateName;
    private String assessOperatePhone;
    private String assessOperateEmail;
    private String assessOperateAddress;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date assessTime;
    private String assessPath;
    private String username;

    public Integer getAssessId() {
        return assessId;
    }

    public void setAssessId(Integer assessId) {
        this.assessId = assessId;
    }

    public String getAssessName() {
        return assessName;
    }

    public void setAssessName(String assessName) {
        this.assessName = assessName;
    }

    public String getAssessBoss() {
        return assessBoss;
    }

    public void setAssessBoss(String assessBoss) {
        this.assessBoss = assessBoss;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getAssessSigntime() {
        return assessSigntime;
    }

    public void setAssessSigntime(Date assessSigntime) {
        this.assessSigntime = assessSigntime;
    }

    public String getAssessAddress() {
        return assessAddress;
    }

    public void setAssessAddress(String assessAddress) {
        this.assessAddress = assessAddress;
    }

    public String getAssessType() {
        return assessType;
    }

    public void setAssessType(String assessType) {
        this.assessType = assessType;
    }

    public String getAssessEmail() {
        return assessEmail;
    }

    public void setAssessEmail(String assessEmail) {
        this.assessEmail = assessEmail;
    }

    public String getAssessPhone() {
        return assessPhone;
    }

    public void setAssessPhone(String assessPhone) {
        this.assessPhone = assessPhone;
    }

    public String getAssessOperateName() {
        return assessOperateName;
    }

    public void setAssessOperateName(String assessOperateName) {
        this.assessOperateName = assessOperateName;
    }

    public String getAssessOperatePhone() {
        return assessOperatePhone;
    }

    public void setAssessOperatePhone(String assessOperatePhone) {
        this.assessOperatePhone = assessOperatePhone;
    }

    public String getAssessOperateEmail() {
        return assessOperateEmail;
    }

    public void setAssessOperateEmail(String assessOperateEmail) {
        this.assessOperateEmail = assessOperateEmail;
    }

    public String getAssessOperateAddress() {
        return assessOperateAddress;
    }

    public void setAssessOperateAddress(String assessOperateAddress) {
        this.assessOperateAddress = assessOperateAddress;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getAssessTime() {
        return assessTime;
    }

    public void setAssessTime(Date assessTime) {
        this.assessTime = assessTime;
    }

    public String getAssessPath() {
        return assessPath;
    }

    public void setAssessPath(String assessPath) {
        this.assessPath = assessPath;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Assess{" +
                "assessId=" + assessId +
                ", assessName='" + assessName + '\'' +
                ", assessBoss='" + assessBoss + '\'' +
                ", assessSigntime=" + assessSigntime +
                ", assessAddress='" + assessAddress + '\'' +
                ", assessType='" + assessType + '\'' +
                ", assessEmail='" + assessEmail + '\'' +
                ", assessPhone='" + assessPhone + '\'' +
                ", assessOperateName='" + assessOperateName + '\'' +
                ", assessOperatePhone='" + assessOperatePhone + '\'' +
                ", assessOperateEmail='" + assessOperateEmail + '\'' +
                ", assessOperateAddress='" + assessOperateAddress + '\'' +
                ", assessTime=" + assessTime +
                ", assessPath='" + assessPath + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
