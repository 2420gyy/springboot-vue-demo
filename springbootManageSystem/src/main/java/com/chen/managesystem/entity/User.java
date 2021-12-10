package com.chen.managesystem.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenchen
 * @since 2021-12-10
 */
@Getter
@Setter
@TableName("user")
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("uuid")
    @TableId("ID")
    private String id;

    @TableField("NAME")
    private String name;

    @TableField("AGE")
    private Integer age;

    @ApiModelProperty("0 女，1 男")
    @TableField("GENDER")
    private Integer gender;

    @TableField("NICK_NAME")
    private String nickName;

    @TableField("PASSWORD")
    private String password;

    @TableField("PHONE")
    private String phone;

    @TableField("EMAIL")
    private String email;

    @ApiModelProperty("是否管理员 0非，1是")
    @TableField("IS_ADMIN")
    private Integer isAdmin;

    @ApiModelProperty("VIP状态 0非vip，1vip")
    @TableField("IS_VIP")
    private Integer isVip;

    @ApiModelProperty("删除状态 0未删除，1删除")
    @TableField("IS_DELETE")
    @TableLogic
    private Integer isDelete;

    @ApiModelProperty("创建者")
    @TableField("CREATE_USER")
    private String createUser;

    @ApiModelProperty("创建时间")
    @TableField("CREATE_TIME")
    private LocalDateTime createTime;

    @ApiModelProperty("删除人")
    @TableField("DELETE_USER")
    private String deleteUser;

    @ApiModelProperty("更新时间")
    @TableField("UPDATE_TIME")
    private LocalDateTime updateTime;

    @ApiModelProperty("更新者")
    @TableField("UPDATE_USER")
    private String updateUser;

    @ApiModelProperty("删除时间")
    @TableField("DELETE_TIME")
    private LocalDateTime deleteTime;


}
