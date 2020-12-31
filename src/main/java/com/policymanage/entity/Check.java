package com.policymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Check implements Serializable {
    private Integer checkId;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date checkTime;
    private String checkResult;
    private String checkRemark;

    public Integer getCheckId() {
        return checkId;
    }

    public void setCheckId(Integer checkId) {
        this.checkId = checkId;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(Date checkTime) {
        this.checkTime = checkTime;
    }

    public String getCheckResult() {
        return checkResult;
    }

    public void setCheckResult(String checkResult) {
        this.checkResult = checkResult;
    }

    public String getCheckRemark() {
        return checkRemark;
    }

    public void setCheckRemark(String checkRemark) {
        this.checkRemark = checkRemark;
    }

    @Override
    public String toString() {
        return "Check{" +
                "checkId=" + checkId +
                ", checkTime=" + checkTime +
                ", checkResult='" + checkResult + '\'' +
                ", checkRemark='" + checkRemark + '\'' +
                '}';
    }
}
