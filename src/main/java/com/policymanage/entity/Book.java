package com.policymanage.entity;

import java.io.Serializable;

public class Book implements Serializable {
    private Integer bookId;
    private String bookName;
    private String bookUnit;
    private String bookPhone;
    private String bookEmail;
    private Integer bookUserid;

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookUnit() {
        return bookUnit;
    }

    public void setBookUnit(String bookUnit) {
        this.bookUnit = bookUnit;
    }

    public String getBookPhone() {
        return bookPhone;
    }

    public void setBookPhone(String bookPhone) {
        this.bookPhone = bookPhone;
    }

    public String getBookEmail() {
        return bookEmail;
    }

    public void setBookEmail(String bookEmail) {
        this.bookEmail = bookEmail;
    }

    public Integer getBookUserid() {
        return bookUserid;
    }

    public void setBookUserid(Integer bookUserid) {
        this.bookUserid = bookUserid;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookId=" + bookId +
                ", bookName='" + bookName + '\'' +
                ", bookUnit='" + bookUnit + '\'' +
                ", bookPhone='" + bookPhone + '\'' +
                ", bookEmail='" + bookEmail + '\'' +
                ", bookUserid=" + bookUserid +
                '}';
    }
}
