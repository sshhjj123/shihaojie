package com.study.service;

import com.study.pojo.Class;
import com.study.utils.JsonResult;

public interface IClassService {
    JsonResult<Class> list(Class entry);
    JsonResult<Class> save(Class entry);
    JsonResult<Class> update(Class entry);
    JsonResult<Class> delete(Integer id);
}
