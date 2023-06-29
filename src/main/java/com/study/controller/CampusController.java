package com.study.controller;

import com.study.pojo.Campus;
import com.study.service.ICampusService;
import com.study.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
@CrossOrigin("*")
@RestController
@RequestMapping("/campus")
public class CampusController {
    @Autowired
    private ICampusService campusService;
    @PostMapping("/list")
    public JsonResult<Campus> list(@RequestBody Campus campus){
        return campusService.list(campus);
    }
    @PostMapping("/save")
    public JsonResult<Campus> save(@RequestBody Campus campus){
        campus.setCreatetime(new Date());
        return campusService.save(campus);
    }
    @PutMapping("/update")
    public JsonResult<Campus> update(@RequestBody Campus campus){
        campus.setCreatetime(new Date());
        return campusService.update(campus);
    }
    @DeleteMapping("/delete/{id}")
    public JsonResult<Campus> delete(@PathVariable Integer id){
        return campusService.delete(id);
    }

}
