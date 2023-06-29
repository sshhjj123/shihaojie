package com.study.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
@TableName("t_comment")
public class Comment  implements Serializable {
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    private String name;
    private String content;
    private String headurl;
    private String courseitemid;
    private Date createtime;
}
