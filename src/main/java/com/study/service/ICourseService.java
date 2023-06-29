package com.study.service;

import com.study.pojo.Course;
import com.study.pojo.CourseItem;
import com.study.utils.JsonResult;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author 1
 * @since 2023-05-07
 */
public interface ICourseService {
    JsonResult<Course> list(Course entry);
    JsonResult<Course> item(Integer id);
    JsonResult<Course> save(Course entry);
    JsonResult<Course> update(Course entry);
    JsonResult<Course> delete(Integer id);
}
