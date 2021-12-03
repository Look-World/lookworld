package com.example.lookworld.Base.Role.Server.Impl;

import com.example.lookworld.Base.Role.Entry.RoleEntry;
import com.example.lookworld.Base.Role.Mapper.RoleMapper;
import com.example.lookworld.Base.Role.Server.RoleServer;
import com.example.lookworld.My.MyRuturn.R;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RoleImpl implements RoleServer {

    @Resource
    RoleMapper roleMapper;
    @Override
    public R addRole(RoleEntry roleEntry) {
        if (roleEntry.getRoleName() == null) {
           return R.error("角色名（中文）不可为空");
        }
        if (roleEntry.getRoleAlias() == null) {
            return R.error("角色名（english）不可为空");
        }
        if (roleEntry.getRoleAlias() == null) {
            return R.error("排序 不可为空");
        }
        int result =  roleMapper.insert(roleEntry);
        if (result != 1){
            return R.error("功能使用失败");
        }
        return R.success("成功");
    }
}
