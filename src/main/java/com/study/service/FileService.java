package com.study.service;

import com.study.pojo.FileInfo;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {
    String localDir = "D:\\study_project\\study-web\\src\\image";
    FileInfo upload(MultipartFile file);
}
