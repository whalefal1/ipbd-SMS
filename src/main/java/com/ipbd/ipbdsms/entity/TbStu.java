package com.ipbd.ipbdsms.entity;


import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 学生信息表
 * @TableName tb_stu
 */
@TableName(value ="tb_stu")
@Data
public class TbStu implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 姓名
     */
    private String stuName;

    /**
     * 性别
     */
    private String stuGender;

    /**
     * 组别（“super”和其他）
     */
    private String stuGroup;

    /**
     * 年级（20XX）
     */
    private Integer stuGrade;

    /**
     * 头像照片（存储链接地址）
     */
    private String image;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 逻辑删除（0代表未删除；1代表已删除）
     */
    private Integer isDeleted;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}