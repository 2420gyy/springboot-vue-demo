package com.chen.managesystem.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenchen
 * @since 2021-12-10
 */
@Data
@ApiModel(value = "User对象", description = "")
public class User implements Serializable {


    @ApiModelProperty(value = "uuid")
    private String ID;

    private String NAME;

    private Integer AGE;

    @ApiModelProperty(value = "0 女，1 男")
    private Integer GENDER;

    private String NICK_NAME;

    private String PASSWORD;

    private String PHONE;

    private String EMAIL;

    @ApiModelProperty(value = "是否管理员 0非，1是")
    private Integer IS_ADMIN;

    @ApiModelProperty(value = "VIP状态 0非vip，1vip")
    private Integer IS_VIP;

    @ApiModelProperty(value = "删除状态 0未删除，1删除")
    private Integer IS_DELETE;

    @ApiModelProperty(value = "创建者")
    private String CREATE_USER;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime CREATE_TIME;

    @ApiModelProperty(value = "删除人")
    private String DELETE_USER;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime UPDATE_TIME;

    @ApiModelProperty(value = "更新者")
    private String UPDATE_USER;

    @ApiModelProperty(value = "删除时间")
    private LocalDateTime DELETE_TIME;
}
