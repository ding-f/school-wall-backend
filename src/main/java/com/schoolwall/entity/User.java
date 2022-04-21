package com.schoolwall.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
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
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("sw_user")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @Email(message = "邮箱格式不正确")
    @NotBlank(message = "请输入邮箱，这将作为您的登录账号")
    private String userName;

    @NotBlank(message = "必须为您的账号设置一个密码")
    private String password;

    @NotBlank(message = "请输入学生账号")
    private String studentNum;

    private String avatarUrl;

    private String nickName;

    private String phone;

    private String email;

    private String age;

    private String openId;

    private String wxName;

    private String wxAvatarUrl;

    private String useMask;

    private String enable;

    private LocalDateTime registerDate;


}
