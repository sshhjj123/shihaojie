package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.mapper.CourseMapper;
import com.study.pojo.Course;
import com.study.service.ICourseService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseServiceImpl implements ICourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Override
    public JsonResult<Course> list(Course entry) {
        QueryWrapper<Course> qw = new QueryWrapper<Course>();
        qw.like((!Objects.isNull(entry.getName())&&(!"".equals(entry.getName()))),"name",entry.getName());
        qw.eq((!Objects.isNull(entry.getUsername())&&(!"".equals(entry.getUsername()))),"username",entry.getUsername());
        qw.eq((!Objects.isNull(entry.getCampus())&&(!"".equals(entry.getCampus()))),"campus",entry.getCampus());
        List<Course> list = courseMapper.selectList(qw);
        return JsonResult.success(list,"查询成功");
    }

    @Override
    public JsonResult<Course> item(Integer id) {
        return JsonResult.success(courseMapper.selectById(id),"查询成功");
    }

    @Override
    public JsonResult<Course> save(Course entry) {
        int res = courseMapper.insert(entry);
        if(res==1){
            return JsonResult.success("新增成功");
        }
        return JsonResult.success("新增失败");
    }

    @Override
    public JsonResult<Course> update(Course entry) {
        int res = courseMapper.updateById(entry);
        if(res==1){
            return JsonResult.success("更新成功");
        }
        return JsonResult.success("更新失败");
    }

    @Override
    public JsonResult<Course> delete(Integer id) {
        int res = courseMapper.deleteById(id);
        if(res==1){
            return JsonResult.success("删除成功");
        }
        return JsonResult.success("删除失败");
    }
}
