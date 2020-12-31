package com.policymanage.activiti.entity;

import org.joda.time.DateTime;

import java.sql.Timestamp;

public class Process {
    private String ID_;
    private Integer REV_;
    private String EXECUTION_ID_;
    private String PROC_INST_ID_;
    private String PROC_DEF_ID_;
    private String NAME_;
    private String PARENT_TASK_ID_;
    private String DESCRIPTION_;
    private String TASK_DEF_KEY_;
    private String OWNER_;
    private String ASSIGNEE_;
    private String DELEGATION_;
    private Integer PRIORITY_;
    private Timestamp CREATE_TIME_;
    private DateTime DUE_DATE_;
    private String CATEGORY_;
    private Integer SUSPENSION_STATE_;
    private String TENANT_ID_;
    private String FORM_KEY_;

    public String getID_() {
        return ID_;
    }

    public void setID_(String ID_) {
        this.ID_ = ID_;
    }

    public Integer getREV_() {
        return REV_;
    }

    public void setREV_(Integer REV_) {
        this.REV_ = REV_;
    }

    public String getEXECUTION_ID_() {
        return EXECUTION_ID_;
    }

    public void setEXECUTION_ID_(String EXECUTION_ID_) {
        this.EXECUTION_ID_ = EXECUTION_ID_;
    }

    public String getPROC_INST_ID_() {
        return PROC_INST_ID_;
    }

    public void setPROC_INST_ID_(String PROC_INST_ID_) {
        this.PROC_INST_ID_ = PROC_INST_ID_;
    }

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
    }

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public String getPARENT_TASK_ID_() {
        return PARENT_TASK_ID_;
    }

    public void setPARENT_TASK_ID_(String PARENT_TASK_ID_) {
        this.PARENT_TASK_ID_ = PARENT_TASK_ID_;
    }

    public String getDESCRIPTION_() {
        return DESCRIPTION_;
    }

    public void setDESCRIPTION_(String DESCRIPTION_) {
        this.DESCRIPTION_ = DESCRIPTION_;
    }

    public String getTASK_DEF_KEY_() {
        return TASK_DEF_KEY_;
    }

    public void setTASK_DEF_KEY_(String TASK_DEF_KEY_) {
        this.TASK_DEF_KEY_ = TASK_DEF_KEY_;
    }

    public String getOWNER_() {
        return OWNER_;
    }

    public void setOWNER_(String OWNER_) {
        this.OWNER_ = OWNER_;
    }

    public String getASSIGNEE_() {
        return ASSIGNEE_;
    }

    public void setASSIGNEE_(String ASSIGNEE_) {
        this.ASSIGNEE_ = ASSIGNEE_;
    }

    public String getDELEGATION_() {
        return DELEGATION_;
    }

    public void setDELEGATION_(String DELEGATION_) {
        this.DELEGATION_ = DELEGATION_;
    }

    public Integer getPRIORITY_() {
        return PRIORITY_;
    }

    public void setPRIORITY_(Integer PRIORITY_) {
        this.PRIORITY_ = PRIORITY_;
    }

    public Timestamp getCREATE_TIME_() {
        return CREATE_TIME_;
    }

    public void setCREATE_TIME_(Timestamp CREATE_TIME_) {
        this.CREATE_TIME_ = CREATE_TIME_;
    }

    public DateTime getDUE_DATE_() {
        return DUE_DATE_;
    }

    public void setDUE_DATE_(DateTime DUE_DATE_) {
        this.DUE_DATE_ = DUE_DATE_;
    }

    public String getCATEGORY_() {
        return CATEGORY_;
    }

    public void setCATEGORY_(String CATEGORY_) {
        this.CATEGORY_ = CATEGORY_;
    }

    public Integer getSUSPENSION_STATE_() {
        return SUSPENSION_STATE_;
    }

    public void setSUSPENSION_STATE_(Integer SUSPENSION_STATE_) {
        this.SUSPENSION_STATE_ = SUSPENSION_STATE_;
    }

    public String getTENANT_ID_() {
        return TENANT_ID_;
    }

    public void setTENANT_ID_(String TENANT_ID_) {
        this.TENANT_ID_ = TENANT_ID_;
    }

    public String getFORM_KEY_() {
        return FORM_KEY_;
    }

    public void setFORM_KEY_(String FORM_KEY_) {
        this.FORM_KEY_ = FORM_KEY_;
    }

    @Override
    public String toString() {
        return "Process{" +
                "ID_='" + ID_ + '\'' +
                ", REV_=" + REV_ +
                ", EXECUTION_ID_='" + EXECUTION_ID_ + '\'' +
                ", PROC_INST_ID_='" + PROC_INST_ID_ + '\'' +
                ", PROC_DEF_ID_='" + PROC_DEF_ID_ + '\'' +
                ", NAME_='" + NAME_ + '\'' +
                ", PARENT_TASK_ID_='" + PARENT_TASK_ID_ + '\'' +
                ", DESCRIPTION_='" + DESCRIPTION_ + '\'' +
                ", TASK_DEF_KEY_='" + TASK_DEF_KEY_ + '\'' +
                ", OWNER_='" + OWNER_ + '\'' +
                ", ASSIGNEE_='" + ASSIGNEE_ + '\'' +
                ", DELEGATION_='" + DELEGATION_ + '\'' +
                ", PRIORITY_=" + PRIORITY_ +
                ", CREATE_TIME_=" + CREATE_TIME_ +
                ", DUE_DATE_=" + DUE_DATE_ +
                ", CATEGORY_='" + CATEGORY_ + '\'' +
                ", SUSPENSION_STATE_=" + SUSPENSION_STATE_ +
                ", TENANT_ID_='" + TENANT_ID_ + '\'' +
                ", FORM_KEY_='" + FORM_KEY_ + '\'' +
                '}';
    }
}
