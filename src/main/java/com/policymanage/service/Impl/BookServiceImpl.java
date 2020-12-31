package com.policymanage.service.Impl;

import com.policymanage.dao.BookDao;
import com.policymanage.entity.Book;
import com.policymanage.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookDao bookDao;
    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public List<Book> findByUserid(Integer bookUserid) {
        return bookDao.findByUserid(bookUserid);
    }

    @Override
    public void insert(Book book) {
        bookDao.insert(book);
    }

    @Override
    public void update(Book book) {
        bookDao.update(book);
    }

    @Override
    public Book selectById(Integer bookId) {
        return bookDao.selectById(bookId);
    }

    @Override
    public void delete(Integer bookId) {
        bookDao.delete(bookId);
    }
}
