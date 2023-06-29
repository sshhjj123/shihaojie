package com.study.pojo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author 1
 * @since 2023-05-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("t_course_item")
public class CourseItem implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 课程名称
     */
    private String name;

    /**
     * 老师名称
     */
    private String username;

    /**
     * 课程位置
     */
    private String filepath;

    /**
     * 课程头像
     */
    private String imgurl;

    /**
     * 开始时间
     */
    private Date createtime;

    /**
     * 备注
     */
    private String note;


}
