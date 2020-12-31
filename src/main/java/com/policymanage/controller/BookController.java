package com.policymanage.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.policymanage.entity.Book;
import com.policymanage.entity.User;
import com.policymanage.service.BookService;
import com.policymanage.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    @Autowired
    private BookService bookService;
    @Autowired
    private UserService userService;

    /**
     * 跳转至通讯录界面并携带所有数据进行分页
     * @param model
     * @param pn
     * @param ps
     * @return
     */
    @RequestMapping("/getAllInfo")
    public String getlist(ModelMap model,
            /*页码*/
                          @RequestParam(defaultValue = "1", required = true, value="pn") Integer pn,
            /*条数*/
                          @RequestParam(defaultValue = "5", required = true, value="ps") Integer ps
    ) {
        // 获取当前用户的用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        // 获取用户ID
        User user = userService.getByUserName(username);
        Integer id = user.getId();
        // 分页
        PageHelper.startPage(pn, ps);
        List<Book> book = bookService.findByUserid(id);
        PageInfo<Book> pageInfo = new PageInfo<Book>(book);
        model.addAttribute("pageInfo", pageInfo);
        return "BookIndex";
    }

    // 携带id跳转编辑界面
    @RequestMapping("/getBook")
    public String getBook(Model model, Integer bookId) {
        Book book = bookService.selectById(bookId);
        model.addAttribute(book);
        // 获取大写
        String bookName = book.getBookName();
        String str = bookName.toUpperCase();
        char c = str.charAt(0);
        model.addAttribute("initial", c);
        return "BookEdit";
    }

    /**
     * 更新数据
     * @param book
     * @return
     */
    @RequestMapping("/updateBook")
    public String updateBook(Book book) {
        bookService.update(book);
        return "success";
    }

    /**
     * 添加通讯录
     * @param book
     * @return
     */
    @RequestMapping("/insertBook")
    public String insertBook(Book book) {
        // 获取当前用户的用户名
        String username = (String) SecurityUtils.getSubject().getPrincipal();
        // 获取用户ID
        User user = userService.getByUserName(username);
        Integer id = user.getId();
        book.setBookUserid(id);
        System.out.println(book);
        bookService.insert(book);
        return "success";
    }

    // 跳转新增
    @RequestMapping("/skipInsert")
    public String skipInsert() {
        return "BookAdd";
    }

    /*删除企业信息*/
    @RequestMapping("/deleteBook")
    public String deleteBook(Integer bookId) {
        bookService.delete(bookId);
        return "redirect:getAllInfo";
    }
}
