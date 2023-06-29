package com.study.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_class")
public class Class {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String campus;
    private String username;
    private Date createtime;
}
