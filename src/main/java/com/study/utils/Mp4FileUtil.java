//package com.study.utils;
//
//import org.springframework.web.bind.annotation.RequestParam;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletResponse;
//import java.util.HashMap;
//import java.util.Map;
//
///**
// * 文件上传
// */
//public class Mp4FileUtil {
//    private static ServletContext servletContext;
//    public Map<String, Object> kitFileUtil(@RequestParam("imgFile") MultipartFile[] imgFile, HttpServletRequest request,
//                                           HttpServletResponse response, HttpSession session) {
//
//        // 文件保存目录路径
//        //此目录需要先在电脑上进行创建，否则上传文件时通常会报错
//        String savePath = "F:/T/t";
//        System.out.println("正确路径：" + savePath);
//
//        // 文件保存目录URL
//        String saveUrl = request.getContextPath() + "/";
//
//        // 定义允许上传的文件扩展名
//        HashMap<String, String> extMap = new HashMap<String, String>();
//        extMap.put("file", "mp4");
//        // 最大文件大小
//        long maxSize = 5 * 1024 * 1024*1024;
//        response.setContentType("text/html; charset=UTF-8");
//
//        if (!ServletFileUpload.isMultipartContent(request)) {
//            return getError("请选择文件。");
//        }
//        // 检查目录
//        File uploadDir = new File(savePath);
//        if (!uploadDir.exists()) {
//            uploadDir.mkdir();
//            // return getError("上传目录不存在。");
//        }
//
//        // 检查目录写权限
//        if (!uploadDir.canWrite()) {
//            return getError("上传目录没有写权限。");
//        }
//
//        String dirName = request.getParameter("dir");
//
//        String url[] = new String[imgFile.length];
//        Map<String, Object> map = new HashMap<String, Object>();
//        for (int i = 0; i < imgFile.length; i++) {
//            System.out.println(imgFile[i]);
//
//            // 获取上传文件的名字
//            String fileName = imgFile[i].getOriginalFilename();
//            // 获取长度
//            long fileSize = imgFile[i].getSize();
//
//            if (!imgFile[i].isEmpty()) {
//
//                // 检查文件大小
//                if (imgFile[i].getSize() > maxSize) {
//                    return getError("上传文件大小超过限制。");
//                }
//
//                // 检查扩展名
//                String fileExt = fileName.substring(fileName.lastIndexOf(".") + 1).toLowerCase();
//                if (!Arrays.<String>asList(extMap.get(dirName).split(",")).contains(fileExt)) {
//                    return getError("上传文件扩展名是不允许的扩展名。\n只允许" + extMap.get(dirName) + "格式。");
//                }
//
//                SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
//                String newFileName = df.format(new Date()) + "_" + new Random().nextInt(1000) + "." + fileExt;
//                try {
//                    // 保存文件
//                    System.out.println("保存文件" + saveUrl + newFileName);
//                    String fileUrl = saveUrl + newFileName;
//                    FileCopyUtils.copy(imgFile[i].getInputStream(), new FileOutputStream(savePath + newFileName));
//                    session.setAttribute("fileUrl", fileUrl);
//                } catch (Exception e) {
//                    return getError("上传文件失败。");
//                }
//
//                url[i] = saveUrl + newFileName;
//
//            }
//        }
//        map.put("error", 0);
//        map.put("url", url);
//        return map;
//    }
//
//    private Map<String, Object> getError(String message) {
//        Map<String, Object> map = new HashMap<String, Object>();
//        //
//        map.put("error", 101);
//        map.put("message", message);
//        return map;
//    }
//
//}
//
