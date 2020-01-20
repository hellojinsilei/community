package com.listj.community.community.controller;

import com.listj.community.community.dto.FileDTO;
import com.listj.community.community.provider.CloudProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;

@Controller
public class FileController {
    @Autowired
    private CloudProvider cloudProvider;

    @RequestMapping("/file/upload")
    @ResponseBody
    public FileDTO upload(HttpServletRequest request) {
        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
        MultipartFile file = multipartRequest.getFile("editormd-image-file");
        try {
            String fileName=cloudProvider.PutObject(file.getOriginalFilename(),file.getInputStream());
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(1);
            System.out.println("https://listj.bj.bcebos.com/listj/"+file.getOriginalFilename());
            fileDTO.setUrl("https://listj.bj.bcebos.com/listj/"+file.getOriginalFilename());
            return fileDTO;
        } catch (Exception e) {
            FileDTO fileDTO = new FileDTO();
            fileDTO.setSuccess(0);
            fileDTO.setMessage("上传失败");
            return fileDTO;
        }
    }
}
