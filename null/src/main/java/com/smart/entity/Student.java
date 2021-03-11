package com.smart.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author maol
 * @since 2021-03-11
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 学生名字
     */
    private String name;

    /**
     * 学生年龄
     */
    private Integer age;

    /**
     * 学生出生日期
     */
    private Date birthday;

    /**
     * 学生住址
     */
    private String addr;


}
