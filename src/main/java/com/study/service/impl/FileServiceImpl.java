package com.study.service.impl;

import com.study.pojo.FileInfo;
import com.study.service.FileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {
    @Override
    public FileInfo upload(MultipartFile file) {
        FileInfo fileInfo = new FileInfo();
        String fileName = file.getOriginalFilename();
        fileName = fileName.toLowerCase();
        if(!fileName.matches("^.+\\.(jpg|png|gif|mp4)$")){
            return null;
        }
        //2.防止木马病毒
        try {
            //3.分目录存储 提交的时间
            String datePath = new SimpleDateFormat("/yyyy/")
                    .format(new Date());
            fileInfo.setUrl("image"+datePath+fileName);
            String dirPath = localDir + datePath;
            File dirFile = new File(dirPath);
            if(!dirFile.exists()){
                dirFile.mkdirs();
            }
            //4.实现文件上传
            String realFilePath = dirPath + fileName;
            fileInfo.setDirPath(realFilePath);
            file.transferTo(new File(realFilePath));
        } catch (IOException e) {
            e.printStackTrace();
            //如果出现了异常信息,则返回null即可
            return null;
        }
        return fileInfo;
    }
}
