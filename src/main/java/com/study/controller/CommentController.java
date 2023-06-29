package com.study.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.study.mapper.CommentMapper;
import com.study.pojo.Comment;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentMapper commentMapper;
    @PostMapping("/list")
    public JsonResult<Comment> list(@RequestBody Comment c){
        QueryWrapper<Comment> qw = new QueryWrapper<Comment>();
        qw.eq("courseitemid",c.getCourseitemid());
        return JsonResult.success(commentMapper.selectList(qw),"查询成功");
    }
    @PostMapping("/save")
    public JsonResult<Comment> save(@RequestBody Comment c){
        c.setCreatetime(new Date());
        return JsonResult.success(commentMapper.insert(c),"新增成功");
    }


}
