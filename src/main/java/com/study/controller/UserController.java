package com.study.controller;


import com.study.pojo.User;
import com.study.service.IUserService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author 1
 * @since 2023-05-07
 */
@CrossOrigin("*")
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private IUserService userService;
    @PostMapping("/login")
    public JsonResult<User> login(@RequestBody User user){
        return userService.login(user);
    }
    @PostMapping("/register")
    public JsonResult<User> register(@RequestBody User user){
        return userService.register(user);
    }
    @PutMapping("/update")
    public JsonResult<User> update(@RequestBody User user){
        return userService.updateUser(user);
    }
    @DeleteMapping("/delete/{id}")
    public JsonResult<User> delete(@PathVariable Integer id){
        return userService.deleteUser(id);
    }
}
