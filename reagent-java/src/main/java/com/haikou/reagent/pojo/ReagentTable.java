package com.haikou.reagent.pojo;

import com.baomidou.mybatisplus.annotation.IdType;

import java.time.LocalDateTime;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 试剂订单
 * </p>
 *
 * @author 章卜
 * @since 2021-03-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ApiModel(value="ReagentTable对象", description="试剂订单")
public class ReagentTable implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "订单ID ")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "试剂ID")
    private Integer reagentId;

    @ApiModelProperty(value = "试剂名称 ")
    private String reagentName;

    @ApiModelProperty(value = "试剂纯度")
    private String reagentPurity;

    @ApiModelProperty(value = "试剂含量")
    private String reagentContent;

    @ApiModelProperty(value = "试剂密度")
    private String reagentDensity;

    @ApiModelProperty(value = "试剂危险")
    private String reagentDanger;

    @ApiModelProperty(value = "试剂重量 ")
    private String reagentWeight;

    @ApiModelProperty(value = "试剂单价")
    private String reagentPrice;

    @ApiModelProperty(value = "生产厂家")
    private String manufacturer;

    @ApiModelProperty(value = "供货商家")
    private String supplierName;

    @ApiModelProperty(value = "商家电话")
    private String supplierPhone;

    @ApiModelProperty(value = "订单类型")
    private String orderType;

    @ApiModelProperty(value = "动态图像1")
    private String image1;

    @ApiModelProperty(value = "动态图像2")
    private String image2;

    @ApiModelProperty(value = "动态图像3")
    private String image3;

    @ApiModelProperty(value = "试剂二维码")
    @TableField("QR_image")
    private String qrImage;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "创建时间")
    @TableField(fill = FieldFill.INSERT)
    private LocalDateTime createTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(value = "更新时间 ")
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updateTime;

    @ApiModelProperty(value = "操作员工号 ")
    private Integer operatorId;

    @ApiModelProperty(value = "操作员姓名")
    private String operatorName;

    @ApiModelProperty(value = "设备号")
    private Integer equipmentId;


}
