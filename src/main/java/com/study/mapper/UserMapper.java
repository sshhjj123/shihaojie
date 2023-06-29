package com.study.mapper;

import com.study.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author 1
 * @since 2023-05-07
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

}
