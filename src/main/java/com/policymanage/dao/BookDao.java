package com.policymanage.dao;

import com.policymanage.entity.Book;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookDao {
    /*查询所有*/
    @Select("select * from book")
    @Results(id = "bookMap", value = {
            @Result(column = "b_id", property = "bookId"),
            @Result(column = "b_name", property = "bookName"),
            @Result(column = "b_unit", property = "bookUnit"),
            @Result(column = "b_phone", property = "bookPhone"),
            @Result(column = "b_email", property = "bookEmail"),
            @Result(column = "b_userid", property = "bookUserid")
    })
    public List<Book> findAll();

    /*根据用户bookUserid查询*/
    @Select("select * from book where b_userid = #{bookUserid}")
    @ResultMap(value = "bookMap")
    public List<Book> findByUserid(Integer bookUserid);

    /*新增通讯录*/
    @Insert("insert into book(b_name, b_unit, b_phone, b_email, b_userid) values(#{bookName}, #{bookUnit}, #{bookPhone}, #{bookEmail}, #{bookUserid})")
    @ResultMap(value = "bookMap")
    public void insert(Book book);

    /*更新通讯录*/
    @Update("update book set b_name = #{bookName}, b_unit = #{bookUnit}, b_phone = #{bookPhone}, b_email = #{bookEmail}, b_userid = #{bookUserid} where b_id = #{bookId}")
    @ResultMap(value = "bookMap")
    public void update(Book book);

    /*通过名字查询*/
    @Select("select * from book where b_name like concat('%',#{bookName},'%')")
    @ResultMap(value = "bookMap")
    public List<Book> selectByName(String bookName);

    /*根据id查询*/
    @Select("select * from book where b_id = #{bookId}")
    @ResultMap(value = "bookMap")
    public Book selectById(Integer bookId);

    /*删除信息*/
    @Delete("delete from book where b_id = #{bookId}")
    @ResultMap(value = "bookMap")
    public void delete(Integer bookId);
}
