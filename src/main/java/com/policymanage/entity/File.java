package com.policymanage.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class File implements Serializable {
    private Integer fileId;
    private String fileDutyofficer;
    private String fileResponse;
    private String fileTitle;
    /*解决传入Date导致的格式问题*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fileTime;
    private String filePath;

    public Integer getFileId() {
        return fileId;
    }

    public void setFileId(Integer fileId) {
        this.fileId = fileId;
    }

    public String getFileDutyofficer() {
        return fileDutyofficer;
    }

    public void setFileDutyofficer(String fileDutyofficer) {
        this.fileDutyofficer = fileDutyofficer;
    }

    public String getFileResponse() {
        return fileResponse;
    }

    public void setFileResponse(String fileResponse) {
        this.fileResponse = fileResponse;
    }

    public String getFileTitle() {
        return fileTitle;
    }

    public void setFileTitle(String fileTitle) {
        this.fileTitle = fileTitle;
    }

    /*解决传入Date导致的格式问题*/
    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getFileTime() {
        return fileTime;
    }

    public void setFileTime(Date fileTime) {
        this.fileTime = fileTime;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    @Override
    public String toString() {
        return "File{" +
                "fileId=" + fileId +
                ", fileDutyofficer='" + fileDutyofficer + '\'' +
                ", fileResponse='" + fileResponse + '\'' +
                ", fileTitle='" + fileTitle + '\'' +
                ", fileTime=" + fileTime +
                ", filePath='" + filePath + '\'' +
                '}';
    }
}
