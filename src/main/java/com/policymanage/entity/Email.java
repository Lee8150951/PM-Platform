package com.policymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class Email implements Serializable {
    private Integer emailId;
    private String emailGet;
    private String emailSend;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date emailTime;
    private String emailHead;
    private String emailContent;
    private String emailUrl;

    public Integer getEmailId() {
        return emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

    public String getEmailGet() {
        return emailGet;
    }

    public void setEmailGet(String emailGet) {
        this.emailGet = emailGet;
    }

    public String getEmailSend() {
        return emailSend;
    }

    public void setEmailSend(String emailSend) {
        this.emailSend = emailSend;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getEmailTime() {
        return emailTime;
    }

    public void setEmailTime(Date emailTime) {
        this.emailTime = emailTime;
    }

    public String getEmailHead() {
        return emailHead;
    }

    public void setEmailHead(String emailHead) {
        this.emailHead = emailHead;
    }

    public String getEmailContent() {
        return emailContent;
    }

    public void setEmailContent(String emailContent) {
        this.emailContent = emailContent;
    }

    public String getEmailUrl() {
        return emailUrl;
    }

    public void setEmailUrl(String emailUrl) {
        this.emailUrl = emailUrl;
    }

    @Override
    public String toString() {
        return "Email{" +
                "emailId=" + emailId +
                ", emailGet='" + emailGet + '\'' +
                ", emailSend='" + emailSend + '\'' +
                ", emailTime=" + emailTime +
                ", emailHead='" + emailHead + '\'' +
                ", emailContent='" + emailContent + '\'' +
                ", emailUrl='" + emailUrl + '\'' +
                '}';
    }
}
