package com.schoolwall.wxappfileserver.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;

/**
 * <p>
 * 安康学院校园墙后端
 * </p>
 *
 * @author fuding 铸鼎_ Blog: https://ding-f.gitee.io/
 * @since 2022 2022/5/7 17:23
 */

@RestController
@RequestMapping("/schoolwall_ps")
public class FilesController {

    @PostMapping("/fileup")
    public Boolean fileUp(HttpServletRequest request, @RequestParam("file") MultipartFile images) throws Exception {

        if (images!=null){
            String sysPath = "/Users/fuding/Pictures/AKU-WALL-PS";
            String imagesName = images.getOriginalFilename();

            System.out.println(imagesName);

            File filePath=new File(sysPath + File.separator +imagesName);
            if (!filePath.getParentFile().exists()){
                filePath.getParentFile().mkdirs();
            }

            System.out.println(filePath);

            images.transferTo(filePath);

            return true;
        }else {
            return false;
        }

    }

}
