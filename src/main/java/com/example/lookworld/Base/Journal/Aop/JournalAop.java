package com.example.lookworld.Base.Journal.Aop;


import com.example.lookworld.Base.Journal.Entry.JournalEntry;
import com.example.lookworld.Base.Journal.Mapper.JournalMapper;
import com.example.lookworld.Base.Journal.Server.JournalServer;
import com.example.lookworld.Base.Login.Entry.UserEntry;
import com.example.lookworld.My.MyRuturn.R;
import com.example.lookworld.My.MyUtils.HttpRequestGetIp;
import com.example.lookworld.My.MyUtils.RedisUtil;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;


@Aspect
@Component
public class JournalAop {

    @Autowired
    JournalServer journalServer;

    @Autowired
    RedisUtil redisUtil;

    @Resource
    JournalMapper journalMapper;


    @Pointcut("execution(* com.example.lookworld.Base.Login.Controller.UserController.login(..)) ")
    private void Login(){

    }

    @AfterReturning(value = "Login()",returning = "r")
    private void LoginLog(JoinPoint joinPoint,R r){
        if(r.getCode() == 500){
            //获取参数
            UserEntry  userEntry1  =(UserEntry)joinPoint.getArgs()[0];
            HttpServletRequest request1 =(HttpServletRequest)joinPoint.getArgs()[1];

            JournalEntry journalEntry1 = new JournalEntry();
            journalEntry1.setIp(HttpRequestGetIp.getIpAddress(request1));
            journalEntry1.setOperation("登录");
            journalEntry1.setOperationResult("失败:账号或密码错误");
            journalEntry1.setCreateUser(userEntry1.getAccount());
            journalEntry1.setCreateTime(new Date());
            journalMapper.insert(journalEntry1);
        }

        if(r.getCode() == 200 || r.getCode() == 204){
            //获取参数
            UserEntry  userEntry  =(UserEntry)joinPoint.getArgs()[0];
            HttpServletRequest request =(HttpServletRequest)joinPoint.getArgs()[1];

            JournalEntry journalEntry = new JournalEntry();
            journalEntry.setIp(HttpRequestGetIp.getIpAddress(request));
            journalEntry.setOperation("登录");
            journalEntry.setOperationResult("成功");
            journalEntry.setCreateUser(userEntry.getAccount());
            journalEntry.setCreateTime(new Date());
            journalMapper.insert(journalEntry);
        }

    }

}
