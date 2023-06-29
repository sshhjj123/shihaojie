package com.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.mapper.CampusMapper;
import com.study.pojo.Campus;
import com.study.service.ICampusService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class CampusServiceImpl implements ICampusService {
    @Autowired
    private CampusMapper CampusMapper;
    @Override
    public JsonResult<Campus> list(Campus entry) {
        QueryWrapper<Campus> qw = new QueryWrapper<Campus>();
        qw.like((!Objects.isNull(entry.getName())&&(!"".equals(entry.getName()))),"name",entry.getName());
        qw.eq((!Objects.isNull(entry.getUsername())&&(!"".equals(entry.getUsername()))),"username",entry.getUsername());
        List<Campus> list = CampusMapper.selectList(qw);
        return JsonResult.success(list,"查询成功");
    }

    @Override
    public JsonResult<Campus> save(Campus entry) {
        int res = CampusMapper.insert(entry);
        if(res==1){
            return JsonResult.success("新增成功");
        }
        return JsonResult.success("新增失败");
    }

    @Override
    public JsonResult<Campus> update(Campus entry) {
        int res = CampusMapper.updateById(entry);
        if(res==1){
            return JsonResult.success("更新成功");
        }
        return JsonResult.success("更新失败");
    }

    @Override
    public JsonResult<Campus> delete(Integer id) {
        int res = CampusMapper.deleteById(id);
        if(res==1){
            return JsonResult.success("删除成功");
        }
        return JsonResult.success("删除失败");
    }
}
