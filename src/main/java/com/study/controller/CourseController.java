package com.study.controller;

import com.study.pojo.Course;
import com.study.service.ICourseService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/course")
public class CourseController {
    @Autowired
    private ICourseService courseService;
    @PostMapping("/list")
    public JsonResult<Course> list(@RequestBody Course course){
        return courseService.list(course);
    }
    @GetMapping("/item/{id}")
    public JsonResult<Course> item(@PathVariable Integer id){
        return courseService.item(id);
    }
    @PostMapping("/save")
    public JsonResult<Course> save(@RequestBody Course course){
        course.setCreatetime(new Date());
        return courseService.save(course);
    }
    @PutMapping("/update")
    public JsonResult<Course> update(@RequestBody Course course){
        course.setCreatetime(new Date());
        return courseService.update(course);
    }
    @DeleteMapping("/delete/{id}")
    public JsonResult<Course> delete(@PathVariable Integer id){
        return courseService.delete(id);
    }

}
