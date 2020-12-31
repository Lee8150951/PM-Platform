package com.policymanage.entity;

import java.io.Serializable;

public class Opinion implements Serializable {
    private Integer opinionId;
    private String opinionContent;
    private String opinionUser;

    public Integer getOpinionId() {
        return opinionId;
    }

    public void setOpinionId(Integer opinionId) {
        this.opinionId = opinionId;
    }

    public String getOpinionContent() {
        return opinionContent;
    }

    public void setOpinionContent(String opinionContent) {
        this.opinionContent = opinionContent;
    }

    public String getOpinionUser() {
        return opinionUser;
    }

    public void setOpinionUser(String opinionUser) {
        this.opinionUser = opinionUser;
    }

    @Override
    public String toString() {
        return "Opinion{" +
                "opinionId=" + opinionId +
                ", opinionContent='" + opinionContent + '\'' +
                ", opinionUser='" + opinionUser + '\'' +
                '}';
    }
}
