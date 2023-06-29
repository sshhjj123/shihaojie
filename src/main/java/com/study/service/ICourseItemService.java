package com.study.service;

import com.study.pojo.Course;
import com.study.pojo.CourseItem;
import com.study.utils.JsonResult;

public interface ICourseItemService {
    JsonResult<CourseItem> list(CourseItem entry);
    JsonResult<CourseItem> item(Integer id);
    JsonResult<CourseItem> save(CourseItem entry);
    JsonResult<CourseItem> update(CourseItem entry);
    JsonResult<CourseItem> delete(Integer id);
}
