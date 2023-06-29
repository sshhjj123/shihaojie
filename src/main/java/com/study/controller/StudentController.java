package com.study.controller;

import com.study.pojo.StudentClass;
import com.study.pojo.User;
import com.study.service.IUserService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private IUserService userService;
    @PostMapping("/list")
    public JsonResult<User> getList(@RequestBody User user){
       return userService.list(user);
    }
    @PostMapping("/save")
    public JsonResult<User> save(@RequestBody StudentClass studentClass){
        return userService.insertmany(studentClass);
    }
}
