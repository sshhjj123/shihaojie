package com.study.controller;

import com.study.pojo.CourseItem;
import com.study.service.ICourseItemService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/course-item")
public class CourseItemController {
    @Autowired
    private ICourseItemService courseItemService;
    @PostMapping("/list")
    public JsonResult<CourseItem> list(@RequestBody CourseItem courseItem){
        return courseItemService.list(courseItem);
    }
    @GetMapping("/item/{id}")
    public JsonResult<CourseItem> item(@PathVariable Integer id){
        return courseItemService.item(id);
    }
    @PostMapping("/save")
    public JsonResult<CourseItem> save(@RequestBody CourseItem courseItem){
        courseItem.setCreatetime(new Date());
        return courseItemService.save(courseItem);
    }
    @PutMapping("/update")
    public JsonResult<CourseItem> update(@RequestBody CourseItem courseItem){
        courseItem.setCreatetime(new Date());
        return courseItemService.update(courseItem);
    }
    @DeleteMapping("/delete/{id}")
    public JsonResult<CourseItem> delete(@PathVariable Integer id){
        return courseItemService.delete(id);
    }

}
