package com.example.lookworld.Base.Login.Entry;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.lookworld.Base.Login.Entry.Validation.UserValidation;
import com.example.lookworld.Base.Login.Server.UserServer;
import com.example.lookworld.My.MyBase.BaseEntry;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userinfo")
public class UserEntry extends BaseEntry implements Serializable {

    //账号
    @NotEmpty(groups = {UserValidation.Login.class},message = "账号不可为空")
    @NotEmpty(groups = {UserValidation.registered.class},message = "账号不可为空")
    private String account;
    //密码
    @NotEmpty(groups = {UserValidation.Login.class},message = "密码不可为空")
    @NotEmpty(groups = {UserValidation.registered.class},message = "密码不可为空")
    private String password;
    //昵称
    @NotEmpty(groups = {UserValidation.Login.class},message = "昵称不可为空")
    private String name;
    //真名
    @NotEmpty(groups = {UserValidation.Login.class},message = "真名不可为空")
    private String realName;
    //头像
    private String avatar;
    //邮箱
    private String email;
    //电话
    @Pattern(groups = {UserValidation.Login.class},regexp = "^1(3|4|5|7|8)\\d{9}$",message = "手机号码格式错误")
    private String phone;
    //生日
    private String birthday;
    //性别
    private String sex;
    //角色
    @NotEmpty(groups = {UserValidation.Login.class},message = "角色不可为空")
    private Long roleId;
    //状态
    private String status;


}
