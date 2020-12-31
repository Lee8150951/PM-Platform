package com.policymanage.utils;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class UploadUtils {
    // 转为静态方法，降低耦合
    public static String upload(String path, MultipartFile multipartFile){
        // 返回文件的类型，列出getContentType是返回文件的类型
        String type = multipartFile.getContentType();
        // 获取文件的原始名称
        String originalFilename = multipartFile.getOriginalFilename();
        // 判断是否为空
        if (originalFilename == null) {
            return null;
        }
        // 解决upload目录下文件累积的问题
        // 获取文件原名称的hashcode
        int hashCode = originalFilename.hashCode();
        // 获取upload下第一个目录的名称upload/n
        int dir1 = hashCode & 0xf;
        // 获取upload下n目录下的目录名称upload/n/n
        int dir2 = (hashCode & 0xf0) >> 4;
        // 拼接路径，path是传过来的文件保存路径，upload的真实路径
        String dir = path + File.separator + dir1 + File.separator + dir2;
        // 将路径保存至File中
        File file = new File(dir);
        // 判断是否为空，空则创建
        if (!file.exists()) {
            file.mkdirs();
        }
        // 防止文件重名问题
        String newFileName = UUID.randomUUID().toString().replace("-","")+"."+originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        InputStream is = null;
        OutputStream os = null;
        try {
            is = multipartFile.getInputStream();
            os = new FileOutputStream(dir+File.separator+newFileName);
            //对文件进行复制
            FileCopyUtils.copy(is,os);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (is!=null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (os!=null){
                try {
                    os.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        //返回文件的路径，以便保存到数据库中
        return dir1+File.separator+dir2+File.separator+newFileName;
    }
}
