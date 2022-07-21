package com.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

/**
 * <p>
 * 
 * </p>
 *
 * @author fuding
 * @since 2022-03-16
 */

@ApiModel("用户信息PO")
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sw_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "用户ID,自动生成")
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @ApiModelProperty(value = "微信号", example = "zhuding_1024" )
    private String wxId;

    @ApiModelProperty(value = "登陆用邮箱）", required = true, example = "f_ding@126.com" )
    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "请输入邮箱，这将作为您的登录账号")
    private String userName;

    @ApiModelProperty(value = "登陆密码", required = true, example = "zhuding123" )
    @NotBlank(message = "必须为您的账号设置一个密码")
    private String password;

    @ApiModelProperty(value = "学院学生号（设置可用学生号+密码登陆）", required = true, example = "2020020000" )
    @NotBlank(message = "请输入学生账号")
    private String studentNum;

    @ApiModelProperty(value = "用户自定义头像（图片链接）" )
    private String avatarUrl;

    @ApiModelProperty(value = "用户自定义昵称", example = "铸鼎" )
    private String nickName;

    @ApiModelProperty(value = "联系电话", example = "177*****321" )
    private String phone;

    @ApiModelProperty(value = "邮箱")
    private String email;

    @ApiModelProperty(value = "年龄", example = "18" )
    private Integer age;

    @ApiModelProperty(value = "微信身份ID（OpenID，注册或登陆小程序获得）", example = "o7DTV4p5l0****vmSTss" )
    private String openId;

    private String wxName;

    @ApiModelProperty(value = "微信用户头像（注册或登陆小程序获得）", example = "https://thirdwx.qlogo.cn/mmopen/vi_32/Ne1NOq8ScicXNY7U8qtbU4JXAGNKOuibrrRKDRHxHvPcR5EoD0K2cDIU1Xyk16yUdcKON61RRTRt0SianCegtsYzg/132" )
    private String wxAvatarUrl;

//    private String useMask;

    @ApiModelProperty(value = "角色", required = true, example = "1")
    private String role;

    @ApiModelProperty(value = "账号是否已被禁用（1未禁用，0已禁用）", required = true, example = "1" )
    private String enable;

    @ApiModelProperty(value = "注册日期（DATETIME）", example = "2022-04-22 23:18:59")
    private LocalDateTime registerDate;


}
