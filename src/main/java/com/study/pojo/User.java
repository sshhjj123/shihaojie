package com.study.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author 1
 * @since 2023-05-07
 */
@Data
@TableName("t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 学号
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 账号
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐值
     */
    private String salt;

    /**
     * 头像
     */
    private String headurl;

    /**
     * 邮箱
     */
    private String phone;

    /**
     * 所在班级
     */
    private String classname;

    /**
     * 角色
     */
    private Integer roleid;
    /**
     * 简历
     */
    private String note;
    /**
     * 昵称
     */
    private String nickname;
    /**
     * 学院/专业
     */
    private String campusname;
}
