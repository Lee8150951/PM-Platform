package com.policymanage.service;

import com.policymanage.entity.Book;

import java.util.List;

public interface BookService {
    /*查询所有*/
    public List<Book> findAll();

    /*根据用户bookUserid查询*/
    public List<Book> findByUserid(Integer bookUserid);

    /*新增通讯录*/
    public void insert(Book book);

    /*更新通讯录*/
    public void update(Book book);

    /*根据id查询*/
    public Book selectById(Integer bookId);

    /*删除信息*/
    public void delete(Integer bookId);
}
