package com.example.lookworld.BaseLogin.Controller;

import com.example.lookworld.BaseLogin.Entry.UserEntry;
import com.example.lookworld.BaseLogin.Server.UserServer;
import com.example.lookworld.My.MyRuturn.R;
import com.example.lookworld.My.MyUtils.HttpRequestGetIp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    UserServer userServer;

    @RequestMapping("login")
    public R login(UserEntry userEntry, HttpServletRequest httpServletRequest){
        String ip = HttpRequestGetIp.getIpAddress(httpServletRequest);
        return userServer.login(userEntry,ip);
    }


}
