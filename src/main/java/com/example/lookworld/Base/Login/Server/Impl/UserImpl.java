package com.example.lookworld.Base.Login.Server.Impl;

import com.example.lookworld.Base.Login.Entry.UserEntry;
import com.example.lookworld.Base.Login.Mapper.UserMapper;
import com.example.lookworld.Base.Login.Server.UserServer;
import com.example.lookworld.My.MyRuturn.R;
import com.example.lookworld.My.MyUtils.GetIdUtils;
import com.example.lookworld.My.MyUtils.PassWorldUtils;
import com.example.lookworld.My.MyUtils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserImpl implements UserServer {

    @Resource
    UserMapper userMapper;

    @Autowired
    RedisUtil redisUtil;


    @Override
    public R login(UserEntry userEntry,String ip) {
        if (redisUtil.hasKey(String.valueOf(userEntry.getId()))){
            int Secondary = (int) redisUtil.getString(String.valueOf(userEntry.getId()));
            if(Secondary >5){
                return R.error("账户已锁定，请于24小时后重试");
            }

        }
        // 查询库中数据
        UserEntry userEntry1 = userMapper.selectById(userEntry.getId());
        if (userEntry1 == null){
            return R.error("用户名或密码错误");
        }
        // AES 解密库中密码
        String passWorld  =  PassWorldUtils.AESDecoder(userEntry1.getPassword());
        System.out.println(userEntry1.getPassword());
        //用户名&密码 正确
        if (passWorld.equals(userEntry.getPassword()) && userEntry1.getAccount().equals(userEntry.getAccount()) ){
            String uuid = GetIdUtils.getUUID(1);
            //一小时后过期
            redisUtil.setString(uuid,userEntry.getId(),3600);
            return R.success("登录成功",uuid);
        }
        //用户名&密码 不正确
        if (!passWorld.equals(userEntry.getPassword()) || userEntry1.getAccount().equals(userEntry.getAccount())){
            //在rides中创建计数
            if (!redisUtil.hasKey(String.valueOf(userEntry.getId()))){
                redisUtil.setString(String.valueOf(userEntry.getId()),1,86400);
            }
            // 计数器加1
            if(redisUtil.hasKey(String.valueOf(userEntry.getId()))){
                redisUtil.incr(String.valueOf(userEntry.getId()),1);
            }

            return R.error("用户名或密码错误");
        }
        return R.error("功能使用失败");
    }

    @Override
    public UserEntry getUserInfo(String uuid) {
        if(redisUtil.hasKey(uuid)){
         int id = (int) redisUtil.getString(uuid);
            UserEntry userEntry = userMapper.selectById(id);
            return userEntry;
        }
        return null;
    }
}
