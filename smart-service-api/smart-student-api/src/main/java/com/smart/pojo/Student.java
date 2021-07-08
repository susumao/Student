package com.smart.pojo;


import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@Data
@TableName(value = "student")
public class Student {
    @TableId(value = "id")
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "birthday")
    private Date birthday;
    @TableField(value = "age")
    private Integer age;
    @TableField(value = "addr")
    private String addr;
}
