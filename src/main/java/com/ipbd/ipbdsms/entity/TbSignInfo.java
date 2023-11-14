package com.ipbd.ipbdsms.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 签到信息（记录每个学生，在签到天时的签到状况）
 * @TableName tb_sign_info
 */
@TableName(value ="tb_sign_info")
@Data
public class TbSignInfo implements Serializable {
    /**
     * 
     */
    @TableId
    private Integer id;

    /**
     * - 学期信息 【学年（2023年）+ 学期（第一周）+ 星期（星期一）】
- 
     */
    private String semester;

    /**
     * 签到人员id
     */
    private Integer userId;

    /**
     * - 签到状态（1：准时，2：迟到，3：请假，4：假期）【默认全部准时】
- 
     */
    private Integer signUpStatus;

    /**
     * 签到信息补充 【默认：“暂无”】
     */
    private String signUpRemark;

    /**
     * 签退状态（1：准时，2：迟到，3：请假，4：假期）【默认全部准时】
     */
    private Integer signOutStatus;

    /**
     * - 签退信息补充 【默认：“暂无”】


     */
    private String signOutRemark;

    /**
     * 学年
     */
    private Integer stuYear;

    /**
     * 学期（第几周）
     */
    private Integer stuWeek;

    /**
     * 星期(1)
     */
    private Integer stuWeekDay;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}