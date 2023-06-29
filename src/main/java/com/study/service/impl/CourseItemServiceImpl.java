package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.mapper.CourseItemMapper;
import com.study.pojo.CourseItem;
import com.study.service.ICourseItemService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CourseItemServiceImpl implements ICourseItemService {
    @Autowired
    private CourseItemMapper courseItemMapper;
    @Override
    public JsonResult<CourseItem> list(CourseItem entry) {
        QueryWrapper<CourseItem> qw = new QueryWrapper<CourseItem>();
        qw.like((!Objects.isNull(entry.getName())&&(!"".equals(entry.getName()))),"name",entry.getName());
        qw.eq((!Objects.isNull(entry.getUsername())&&(!"".equals(entry.getUsername()))),"username",entry.getUsername());
        List<CourseItem> list = courseItemMapper.selectList(qw);
        return JsonResult.success(list,"查询成功");
    }

    @Override
    public JsonResult<CourseItem> item(Integer id) {
        return JsonResult.success(courseItemMapper.selectById(id),"查询成功");
    }

    @Override
    public JsonResult<CourseItem> save(CourseItem entry) {
        int res = courseItemMapper.insert(entry);
        if(res==1){
            return JsonResult.success("新增成功");
        }
        return JsonResult.success("新增失败");
    }

    @Override
    public JsonResult<CourseItem> update(CourseItem entry) {
        int res = courseItemMapper.updateById(entry);
        if(res==1){
            return JsonResult.success("更新成功");
        }
        return JsonResult.success("更新失败");
    }

    @Override
    public JsonResult<CourseItem> delete(Integer id) {
        int res = courseItemMapper.deleteById(id);
        if(res==1){
            return JsonResult.success("删除成功");
        }
        return JsonResult.success("删除失败");
    }
}
