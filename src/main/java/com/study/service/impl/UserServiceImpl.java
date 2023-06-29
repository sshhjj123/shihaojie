package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.mapper.CampusMapper;
import com.study.mapper.ClassMapper;
import com.study.pojo.Campus;
import com.study.pojo.Class;
import com.study.pojo.StudentClass;
import com.study.pojo.User;
import com.study.mapper.UserMapper;
import com.study.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author 1
 * @since 2023-05-07
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private CampusMapper campusMapper;
    @Autowired
    private ClassMapper classMapper;
    @Override
    public JsonResult<User> login(User user) {
        QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.eq("username",user.getUsername());
        User user1 = userMapper.selectOne(qw);
        if(!Objects.isNull(user1)){
            if((user.getPassword()+user1.getSalt()).equals(user1.getPassword())){
                return JsonResult.success(user1,"登陆成功");
            }
            return JsonResult.fail(201,"密码错误");
        }
        return JsonResult.fail(201,"账号不存在");
    }

    @Override
    public JsonResult<User> register(User user) {
        QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.eq("username",user.getUsername());
        User item = userMapper.selectOne(qw);
        if(!Objects.isNull(item)){
            return JsonResult.fail(201,"注册失败,账号已存在");
        }
        user.setSalt("jm");
        user.setPassword(user.getPassword()+"jm");
        int res = userMapper.insert(user);
        if(res==1){
            return JsonResult.success("注册成功");
        }
        return JsonResult.fail(201,"注册失败");
    }

    @Override
    public JsonResult<User> list(User user) {
        QueryWrapper<User> qw = new QueryWrapper<User>();
        qw.eq((!Objects.isNull(user.getRoleid())),"roleid",user.getRoleid());
        qw.eq((!Objects.isNull(user.getNickname())&&(!"".equals(user.getNickname()))),"nickname",user.getNickname());
        qw.eq((!Objects.isNull(user.getUsername())&&(!"".equals(user.getUsername()))),"username",user.getUsername());

        return JsonResult.success(userMapper.selectList(qw),"查询成功");
    }

    @Override
    public JsonResult<User> updateUser(User user) {
        int res = userMapper.updateById(user);
        if(res==1){
            return JsonResult.success("更新成功");
        }
        return JsonResult.fail(201,"更新失败");
    }

    @Override
    public JsonResult<User> deleteUser(Integer id) {
        int res = userMapper.deleteById(id);
        if(res==1){
            return JsonResult.success("注销成功");
        }
        return JsonResult.fail(201,"注销失败");
    }

    @Override
    public JsonResult<User> insertmany(StudentClass studentClass) {
        int l = studentClass.getNum();
        QueryWrapper<Campus> qw = new QueryWrapper<>();
        qw.eq("name",studentClass.getCampusname());
        Campus campus = campusMapper.selectOne(qw);
        QueryWrapper<Class> qw1 = new QueryWrapper<Class>();
        qw1.eq("name",studentClass.getClassname());
        Class class1 = classMapper.selectOne(qw1);
        String s = campus.getId()+""+class1.getId();
        QueryWrapper<User> qw2 = new QueryWrapper<User>();
        qw2.eq("classname",studentClass.getClassname());
        List<User> list = userMapper.selectList(qw2);
        int r = 1;
        if(!Objects.isNull(list)){
            l = list.size()+l;
            r = list.size()+1;
        }
        while(r<=l){
            User user = new User();
            user.setNickname(s+l);
            user.setUsername(s+l);
            user.setClassname(studentClass.getClassname());
            user.setCampusname(studentClass.getCampusname());
            user.setNote("");
            user.setHeadurl("");
            user.setRoleid(1);
            user.setSalt("jm");
            user.setPassword("123jm");
            l--;
            userMapper.insert(user);
        }
        return JsonResult.success("新增成功");
    }
}
