package com.example.lookworld.Base.Login.Entry;

import com.baomidou.mybatisplus.annotation.TableName;
import com.example.lookworld.My.MyBase.BaseEntry;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("userinfo")
public class UserEntry extends BaseEntry implements Serializable {

    //账号
    private String account;
    //密码
    private String password;
    //昵称
    private String name;
    //真名
    private String real_name;
    //头像
    private String avatar;
    //邮箱
    private String email;
    //电话
    private String phone;
    //生日
    private String birthday;
    //性别
    private String sex;
    //角色
    private String role_id;


}
