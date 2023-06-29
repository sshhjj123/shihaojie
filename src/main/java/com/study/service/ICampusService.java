package com.study.service;

import com.study.pojo.Campus;
import com.study.utils.JsonResult;

public interface ICampusService {    
    JsonResult<Campus> list(Campus entry);
    JsonResult<Campus> save(Campus entry);
    JsonResult<Campus> update(Campus entry);
    JsonResult<Campus> delete(Integer id);
}
