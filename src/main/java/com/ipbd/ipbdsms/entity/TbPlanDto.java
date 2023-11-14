package com.ipbd.ipbdsms.entity;

import lombok.Data;
import java.util.Date;

@Data
public class TbPlanDto {
    private Integer id;

    /**
     * 学生id
     */
    private String stuName;

    private String stuGroup;

    private Integer stuGrade;


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



}
