package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.mapper.ClassMapper;
import com.study.pojo.Class;
import com.study.service.IClassService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class ClassServiceImpl implements IClassService {
    @Autowired
    private ClassMapper classMapper;
    @Override
    public JsonResult<Class> list(Class entry) {
        QueryWrapper<Class> qw = new QueryWrapper<Class>();
        qw.like((!Objects.isNull(entry.getName())&&(!"".equals(entry.getName()))),"name",entry.getName());
        qw.eq((!Objects.isNull(entry.getUsername())&&(!"".equals(entry.getUsername()))),"username",entry.getUsername());
        List<Class> list = classMapper.selectList(qw);
        return JsonResult.success(list,"查询成功");
    }

    @Override
    public JsonResult<Class> save(Class entry) {
        int res = classMapper.insert(entry);
        if(res==1){
            return JsonResult.success("新增成功");
        }
        return JsonResult.success("新增失败");
    }

    @Override
    public JsonResult<Class> update(Class entry) {
        int res = classMapper.updateById(entry);
        if(res==1){
            return JsonResult.success("更新成功");
        }
        return JsonResult.success("更新失败");
    }

    @Override
    public JsonResult<Class> delete(Integer id) {
        int res = classMapper.deleteById(id);
        if(res==1){
            return JsonResult.success("删除成功");
        }
        return JsonResult.success("删除失败");
    }
}
