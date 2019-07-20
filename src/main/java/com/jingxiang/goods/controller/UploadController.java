package com.jingxiang.goods.controller;

import com.jingxiang.goods.entity.Result;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class UploadController {

    @RequestMapping("/upload")
    public Result upload(@RequestParam("picture")MultipartFile picture,HttpServletRequest request){
        //获取文件在服务器的储存位置,文件的保存路径
        String path = request.getSession().getServletContext().getRealPath("/upload");
        File filePath = new File(path);
        if (!filePath.exists() && !filePath.isDirectory()){
            //目录不存在,创建目录
            filePath.mkdir();
        }
        //原始文件名称
        String originalFilename = picture.getOriginalFilename();
        //文件类型
        String type = originalFilename.substring(originalFilename.lastIndexOf(".")+1);
        //获取文件名称（不包含格式）
        String name = originalFilename.substring(0,originalFilename.lastIndexOf("."));
        Date date = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMddHHmmss");
        format.format(date);
        //设置文件新名称: 当前时间+文件名称（不包含格式）
        String fileName = date+name+"."+type;
        //在指定路径下创建一个文件
        File file = new File(path,fileName);
        try {
            //将文件保存到服务器指定位置
            picture.transferTo(file);
            //将文件在服务器的存储路径返回
            return new Result(true,"/upload/"+fileName);
    }catch (Exception e){
            e.printStackTrace();
            return new Result(false,"上传失败！");
        }
    }
}
