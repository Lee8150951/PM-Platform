package com.policymanage.activiti.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class History implements Serializable {
    private String ID_;
    private String ACT_NAME_;
    private String ASSIGNEE_;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date START_TIME_;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date END_TIME_;

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public String getACT_NAME_() {
        return ACT_NAME_;
    }

    public void setACT_NAME_(String ACT_NAME_) {
        this.ACT_NAME_ = ACT_NAME_;
    }

    public String getASSIGNEE_() {
        return ASSIGNEE_;
    }

    public void setASSIGNEE_(String ASSIGNEE_) {
        this.ASSIGNEE_ = ASSIGNEE_;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getSTART_TIME_() {
        return START_TIME_;
    }

    public void setSTART_TIME_(Date START_TIME_) {
        this.START_TIME_ = START_TIME_;
    }

    @JsonFormat(pattern = "yyyy-MM-dd")
    public Date getEND_TIME_() {
        return END_TIME_;
    }

    public void setEND_TIME_(Date END_TIME_) {
        this.END_TIME_ = END_TIME_;
    }

    @Override
    public String toString() {
        return "History{" +
                "ID_='" + ID_ + '\'' +
                ", ACT_NAME_='" + ACT_NAME_ + '\'' +
                ", ASSIGNEE_='" + ASSIGNEE_ + '\'' +
                ", START_TIME_=" + START_TIME_ +
                ", END_TIME_=" + END_TIME_ +
                '}';
    }
}
