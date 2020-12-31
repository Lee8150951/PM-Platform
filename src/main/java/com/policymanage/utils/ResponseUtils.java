package com.policymanage.utils;

import org.apache.poi.ss.usermodel.Workbook;

import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.URLEncoder;

public class ResponseUtils {
    public static void write(HttpServletResponse response, Object o)throws Exception{
        response.setContentType("text/html;charset=utf-8");
        PrintWriter out=response.getWriter();
        out.print(o.toString());
        out.flush();
        out.close();
    }

    public static void export(HttpServletResponse response, Workbook workbook, String fileName) throws Exception{
        response.setHeader("Content-Disposition", "attachment;filename="+new String(fileName.getBytes("utf-8"),"iso8859-1"));
        response.setContentType("application/ynd.ms-excel;charset=UTF-8");
        OutputStream out=response.getOutputStream();
        workbook.write(out);
        out.flush();
        out.close();
    }

    public static void download(String path, String filename, HttpServletResponse response) throws Exception {
        // 得到要下载的文件
        java.io.File file = new java.io.File(path);
        // 转码
        filename = URLEncoder.encode(filename,"UTF-8");
        // 设置文件下载头
        response.addHeader("Content-Disposition", "attachment;filename=" + filename);
        // 设置文件ContentType类型，自动判断下载文件类型
        response.setContentType("multipart/form-data");
        // 读取要下载的文件，保存到文件输入流
        FileInputStream in = new FileInputStream(path);
        // 创建输出流
        OutputStream out = response.getOutputStream();
        // 创建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        //循环将输入流中的内容读取到缓冲区当中
        while((len = in.read(buffer)) > 0){
            out.write(buffer, 0, len);
        }
        in.close();
        out.close();
    }
}
