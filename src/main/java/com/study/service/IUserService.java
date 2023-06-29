package com.study.service;

import com.study.pojo.StudentClass;
import com.study.pojo.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.study.utils.JsonResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 1
 * @since 2023-05-07
 */
public interface IUserService {
    JsonResult<User> login(User user);
    JsonResult<User> register(User user);
    JsonResult<User> list(User user);
    JsonResult<User> updateUser(User user);
    JsonResult<User> deleteUser(Integer id);
    JsonResult<User> insertmany(StudentClass studentClass);
}
