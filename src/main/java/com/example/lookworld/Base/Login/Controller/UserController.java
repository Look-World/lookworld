package com.example.lookworld.Base.Login.Controller;

import com.example.lookworld.Base.Login.Entry.UserEntry;
import com.example.lookworld.Base.Login.Entry.Validation.UserValidation;
import com.example.lookworld.Base.Login.Server.UserServer;
import com.example.lookworld.My.MyRuturn.R;
import com.example.lookworld.My.MyUtils.HttpRequestGetIp;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;


@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserServer userServer;

    //登录
    @RequestMapping("login")
    public R login( @Validated(UserValidation.registered.class) UserEntry userEntry, HttpServletRequest httpServletRequest){
        String ip = HttpRequestGetIp.getIpAddress(httpServletRequest);
        return userServer.login(userEntry,ip);
    }

    //注册
    @RequestMapping("registered")
    public R registered(String uuid, @Validated(UserValidation.Login.class) UserEntry userEntry, HttpServletRequest httpServletRequest){
        return userServer.registered(userEntry);
    }
}
