package com.ipbd.ipbdsms.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 登录表
- super（最高级）
- admin（组长）
 * @TableName tb_login
 */
@TableName(value ="tb_login")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TbLogin implements Serializable {
    /**
     * 主键
     */
    @TableId
    private Integer id;

    /**
     * 用户名（推荐真实姓名）
     */
    private String username;

    /**
     * 密码（加密后存储）
     */
    private String password;

    /**
     * 组长所属组别（如果是super，组别就是super，其他正常）
     */
    private String group;

    /**
     * 组长所属年级（20XX）
     */
    private Integer grade;

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

    /**
     *身份认证（0代表super；1代表admin）
     */
    private Integer role;
    @TableField(exist = false)
    private static final long serialVersionUID = 1L;


}