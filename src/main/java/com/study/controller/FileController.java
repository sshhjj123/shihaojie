package com.study.controller;

import com.study.pojo.FileInfo;
import com.study.service.FileService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

@CrossOrigin("*")
@RequestMapping("/file")
@RestController
public class FileController {
    @Autowired
    private FileService fileService;
    @PostMapping(value = "/upload")
    public JsonResult<FileInfo> upload(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
        FileInfo fileInfo = fileService.upload(file);;
        return JsonResult.success(fileInfo,"上传成功");
    }
}
