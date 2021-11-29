package com.example.lookworld.Base.Login.Server;

import com.example.lookworld.Base.Login.Entry.UserEntry;
import com.example.lookworld.My.MyRuturn.R;

public interface UserServer {

    /**
     * 登录
     * @param userEntry 用户实体
     * @param ip
     * @return R
     */
    R login(UserEntry userEntry,String ip);

    /**
     * 获取用户信息
     * @param uuid
     * @return 用户信息实体类
     */
    UserEntry getUserInfo(String uuid);


}
