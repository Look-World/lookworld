package com.example.lookworld.Base.Login.Controller;

import com.example.lookworld.Base.Login.Entry.UserEntry;
import com.example.lookworld.Base.Login.Mapper.UserMapper;
import com.example.lookworld.Base.Login.Server.UserServer;
import com.example.lookworld.My.MyRuturn.R;
import com.example.lookworld.My.MyUtils.HttpRequestGetIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;


@CrossOrigin
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServer userServer;

    //登录
    @RequestMapping("login")
    public R login(UserEntry userEntry, HttpServletRequest httpServletRequest){
        String ip = HttpRequestGetIp.getIpAddress(httpServletRequest);
        return userServer.login(userEntry,ip);
    }

    //注册
    @RequestMapping("registered")
    public R registered(String uuid,UserEntry userEntry,HttpServletRequest httpServletRequest){
        return userServer.registered(userEntry);
    }
}
