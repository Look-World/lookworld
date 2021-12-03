package com.example.lookworld.Base.Role.Controller;


import com.example.lookworld.Base.Role.Entry.RoleEntry;

import com.example.lookworld.Base.Role.Mapper.RoleMapper;
import com.example.lookworld.Base.Role.Server.RoleServer;
import com.example.lookworld.My.MyRuturn.R;



import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;
;

@CrossOrigin
@RestController
@RequestMapping("role")
public class RoleController {

    @Resource
    RoleServer roleServer;


    @RequestMapping("add")
    public R addRole(@NotNull(message = "用户id不能为空") String uuid, RoleEntry roleEntry, HttpServletRequest request){
        return roleServer.addRole(roleEntry);
    }

}
