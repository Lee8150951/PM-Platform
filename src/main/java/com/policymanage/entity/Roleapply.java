package com.policymanage.entity;

import java.io.Serializable;

public class Roleapply implements Serializable {
    private Integer id;
    private Integer role_id;
    private Integer opinion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRole_id() {
        return role_id;
    }

    public void setRole_id(Integer role_id) {
        this.role_id = role_id;
    }

    public Integer getOpinion() {
        return opinion;
    }

    public void setOpinion(Integer opinion) {
        this.opinion = opinion;
    }

    @Override
    public String toString() {
        return "Roleapply{" +
                "id=" + id +
                ", role_id=" + role_id +
                ", opinion=" + opinion +
                '}';
    }
}
