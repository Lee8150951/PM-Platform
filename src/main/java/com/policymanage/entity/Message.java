package com.policymanage.entity;

import java.io.Serializable;

public class Message implements Serializable {
    private String msg;
    private String data_1;
    private String data_2;
    private String data_3;
    private String data_4;

    public Message(String msg) {
        this.msg = msg;
    }

    public Message(String msg, String data_1) {
        this.msg = msg;
        this.data_1 = data_1;
    }

    public Message(String msg, String data_1, String data_2) {
        this.msg = msg;
        this.data_1 = data_1;
        this.data_2 = data_2;
    }

    public Message(String msg, String data_1, String data_2, String data_3) {
        this.msg = msg;
        this.data_1 = data_1;
        this.data_2 = data_2;
        this.data_3 = data_3;
    }

    public Message(String msg, String data_1, String data_2, String data_3, String data_4) {
        this.msg = msg;
        this.data_1 = data_1;
        this.data_2 = data_2;
        this.data_3 = data_3;
        this.data_4 = data_4;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getData_1() {
        return data_1;
    }

    public void setData_1(String data_1) {
        this.data_1 = data_1;
    }

    public String getData_2() {
        return data_2;
    }

    public void setData_2(String data_2) {
        this.data_2 = data_2;
    }

    public String getData_3() {
        return data_3;
    }

    public void setData_3(String data_3) {
        this.data_3 = data_3;
    }

    public String getData_4() {
        return data_4;
    }

    public void setData_4(String data_4) {
        this.data_4 = data_4;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                ", data_1='" + data_1 + '\'' +
                ", data_2='" + data_2 + '\'' +
                ", data_3='" + data_3 + '\'' +
                ", data_4='" + data_4 + '\'' +
                '}';
    }
}
