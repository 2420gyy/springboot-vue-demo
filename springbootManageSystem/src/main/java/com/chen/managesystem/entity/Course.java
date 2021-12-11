package com.chen.managesystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

/**
 * <p>
 * 
 * </p>
 *
 * @author chenchen
 * @since 2021-12-11
 */
@Getter
@Setter
@TableName("course")
@ApiModel(value = "Course对象", description = "")
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "ID", type = IdType.AUTO)
    private Integer id;

    @TableField("NAME")
    private String name;

    @TableField("PRICE")
    private BigDecimal price;

    @TableField("AUTHOR")
    private String author;

    @TableField("COVER")
    private String cover;

    @TableField("CREATE_TIME")
    @JsonFormat(pattern = "yyy-MM-dd",timezone = "GMT+8")
    private Date createTime;


}
