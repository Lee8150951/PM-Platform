package com.policymanage.activiti.entity;

import java.sql.Timestamp;

public class Execution {
    private String ID_;
    private Integer REV_;
    private String PROC_INST_ID_;
    private String BUSINESS_KEY_;
    private String PARENT_ID_;
    private String PROC_DEF_ID_;
    private String SUPER_EXEC_;
    private String ACT_ID_;
    private String IS_ACTIVE_;
    private String IS_CONCURRENT_;
    private String IS_SCOPE_;
    private String IS_EVENT_SCOPE_;
    private Integer SUSPENSION_STATE_;
    private Integer CACHED_ENT_STATE_;
    private String TENANT_ID_;
    private String NAME_;
    private Timestamp LOCK_TIME_;

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

    public String getPROC_INST_ID_() {
        return PROC_INST_ID_;
    }

    public void setPROC_INST_ID_(String PROC_INST_ID_) {
        this.PROC_INST_ID_ = PROC_INST_ID_;
    }

    public String getBUSINESS_KEY_() {
        return BUSINESS_KEY_;
    }

    public void setBUSINESS_KEY_(String BUSINESS_KEY_) {
        this.BUSINESS_KEY_ = BUSINESS_KEY_;
    }

    public String getPARENT_ID_() {
        return PARENT_ID_;
    }

    public void setPARENT_ID_(String PARENT_ID_) {
        this.PARENT_ID_ = PARENT_ID_;
    }

    public String getPROC_DEF_ID_() {
        return PROC_DEF_ID_;
    }

    public void setPROC_DEF_ID_(String PROC_DEF_ID_) {
        this.PROC_DEF_ID_ = PROC_DEF_ID_;
    }

    public String getSUPER_EXEC_() {
        return SUPER_EXEC_;
    }

    public void setSUPER_EXEC_(String SUPER_EXEC_) {
        this.SUPER_EXEC_ = SUPER_EXEC_;
    }

    public String getACT_ID_() {
        return ACT_ID_;
    }

    public void setACT_ID_(String ACT_ID_) {
        this.ACT_ID_ = ACT_ID_;
    }

    public String getIS_ACTIVE_() {
        return IS_ACTIVE_;
    }

    public void setIS_ACTIVE_(String IS_ACTIVE_) {
        this.IS_ACTIVE_ = IS_ACTIVE_;
    }

    public String getIS_CONCURRENT_() {
        return IS_CONCURRENT_;
    }

    public void setIS_CONCURRENT_(String IS_CONCURRENT_) {
        this.IS_CONCURRENT_ = IS_CONCURRENT_;
    }

    public String getIS_SCOPE_() {
        return IS_SCOPE_;
    }

    public void setIS_SCOPE_(String IS_SCOPE_) {
        this.IS_SCOPE_ = IS_SCOPE_;
    }

    public String getIS_EVENT_SCOPE_() {
        return IS_EVENT_SCOPE_;
    }

    public void setIS_EVENT_SCOPE_(String IS_EVENT_SCOPE_) {
        this.IS_EVENT_SCOPE_ = IS_EVENT_SCOPE_;
    }

    public Integer getSUSPENSION_STATE_() {
        return SUSPENSION_STATE_;
    }

    public void setSUSPENSION_STATE_(Integer SUSPENSION_STATE_) {
        this.SUSPENSION_STATE_ = SUSPENSION_STATE_;
    }

    public Integer getCACHED_ENT_STATE_() {
        return CACHED_ENT_STATE_;
    }

    public void setCACHED_ENT_STATE_(Integer CACHED_ENT_STATE_) {
        this.CACHED_ENT_STATE_ = CACHED_ENT_STATE_;
    }

    public String getTENANT_ID_() {
        return TENANT_ID_;
    }

    public void setTENANT_ID_(String TENANT_ID_) {
        this.TENANT_ID_ = TENANT_ID_;
    }

    public String getNAME_() {
        return NAME_;
    }

    public void setNAME_(String NAME_) {
        this.NAME_ = NAME_;
    }

    public Timestamp getLOCK_TIME_() {
        return LOCK_TIME_;
    }

    public void setLOCK_TIME_(Timestamp LOCK_TIME_) {
        this.LOCK_TIME_ = LOCK_TIME_;
    }

    @Override
    public String toString() {
        return "Execution{" +
                "ID_='" + ID_ + '\'' +
                ", REV_=" + REV_ +
                ", PROC_INST_ID_='" + PROC_INST_ID_ + '\'' +
                ", BUSINESS_KEY_='" + BUSINESS_KEY_ + '\'' +
                ", PARENT_ID_='" + PARENT_ID_ + '\'' +
                ", PROC_DEF_ID_='" + PROC_DEF_ID_ + '\'' +
                ", SUPER_EXEC_='" + SUPER_EXEC_ + '\'' +
                ", ACT_ID_='" + ACT_ID_ + '\'' +
                ", IS_ACTIVE_='" + IS_ACTIVE_ + '\'' +
                ", IS_CONCURRENT_='" + IS_CONCURRENT_ + '\'' +
                ", IS_SCOPE_='" + IS_SCOPE_ + '\'' +
                ", IS_EVENT_SCOPE_='" + IS_EVENT_SCOPE_ + '\'' +
                ", SUSPENSION_STATE_=" + SUSPENSION_STATE_ +
                ", CACHED_ENT_STATE_=" + CACHED_ENT_STATE_ +
                ", TENANT_ID_='" + TENANT_ID_ + '\'' +
                ", NAME_='" + NAME_ + '\'' +
                ", LOCK_TIME_=" + LOCK_TIME_ +
                '}';
    }
}
