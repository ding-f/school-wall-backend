package com.schoolwall.wxappfileserver.controller;

import com.schoolwall.wxappfileserver.config.AppConfigInfo;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;


/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/7 17:23
 */

@Slf4j
@RestController
@RequestMapping("/schoolwall_fs")
public class FilesController {

    @Autowired
    AppConfigInfo appConfigInfo;

    //文件上传（按照日期保存）
    @PostMapping("/fileup")
    public String fileUp(HttpServletRequest request, @RequestParam("file") MultipartFile images) throws Exception {

        if (images!=null){

            String hostname=appConfigInfo.getHostname();
            String protocol=appConfigInfo.getProtocol();

            SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
            String nowDateString = simpleDateFormat.format(new Date());

            //存放文件目录(打Jar包后依旧生效,文件生成至jar目录下)
            String sysPath = System.getProperty("user.dir") + "/AKU-WALL-FS/" + nowDateString;
            //获取回传文件名称加上UUID保证唯一
            String imagesName = UUID.randomUUID() + "_" + images.getOriginalFilename();

//            System.out.println("user.dir:"+System.getProperty("user.dir"));

//            System.out.println("测试上传文件名："+imagesName);

            //创建空文件到内存
            File filePath=new File(sysPath + File.separator +imagesName);
            //如果目录不存在就创建
            if (!filePath.getParentFile().exists()){

                boolean out= filePath.getParentFile().mkdirs();
                if (!out){
                    log.error("--------------创建文件夹异常--------------");
                }
            }

//            System.out.println("测试上传文件路径"+filePath);

            //写入进去文件存到硬盘
            images.transferTo(filePath);

            return imagesName;
        }else {
//            log.error("--------------服务器未收到文件--------------");
            return null;
        }

    }

    //文件下载（按照日期）
    @GetMapping("/filedown/createdate={date}/filename={filename}")
    public ResponseEntity<byte[]> fileDown(@PathVariable("date") String date,@PathVariable("filename") String fileName) throws IOException {
        //下载文件路径（本项目文件夹的父级文件夹）
        final String PATH=System.getProperty("user.dir") + "/AKU-WALL-FS/";

        //内存中建立需要被下载的文件
        File file = new File(PATH + File.separator + date + File.separator + fileName);
        //设置响应头
        HttpHeaders headers=new HttpHeaders();
        //下载显示的文件名,转码，解决中文名称乱码问题
        String downloadFileName=new String(fileName.getBytes(StandardCharsets.UTF_8), StandardCharsets.ISO_8859_1);
        //通知浏览器以下载方式(attachment) 此方式意思是要么下载要么有内建的框方式打开文件，详见：https://www.rfc-editor.org/rfc/rfc1806.txt
        headers.setContentDispositionFormData("attachment",downloadFileName);
        //定义以二进制流数据(最常见的文件下载)的形式下载返回文件数据
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);

        return new ResponseEntity<>(FileUtils.readFileToByteArray(file), headers, HttpStatus.OK);
    }

}
