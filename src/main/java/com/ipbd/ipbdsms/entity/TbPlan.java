package com.ipbd.ipbdsms.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 计划表
 * @TableName tb_plan
 */
@TableName(value ="tb_plan")
@Data
public class TbPlan implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 学生id
     */
    private Integer stuId;

    /**
     * 当前周数
     */
    private Integer week;

    /**
     * 本周学习内容
     */
    private String thisWeekLearning;

    /**
     * 下周学习计划
     */
    private String nextWeekPlan;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 修改时间
     */
    private Date updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}