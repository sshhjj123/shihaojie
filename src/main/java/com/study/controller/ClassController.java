package com.study.controller;

import com.study.pojo.Class;
import com.study.service.IClassService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@CrossOrigin("*")
@RestController
@RequestMapping("/class")
public class ClassController {
    @Autowired
    private IClassService classService;
    @PostMapping("/list")
    public JsonResult<Class> list(@RequestBody Class c){
        return classService.list(c);
    }
    @PostMapping("/save")
    public JsonResult<Class> save(@RequestBody Class c){
        c.setCreatetime(new Date());
        return classService.save(c);
    }
    @PutMapping("/update")
    public JsonResult<Class> update(@RequestBody Class c){
        c.setCreatetime(new Date());
        return classService.update(c);
    }
    @DeleteMapping("/delete/{id}")
    public JsonResult<Class> delete(@PathVariable Integer id){
        return classService.delete(id);
    }

}
