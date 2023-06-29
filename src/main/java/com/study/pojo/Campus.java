package com.study.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName("t_campus")
public class Campus {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String username;
    private String note;
    private Date createtime;
}
