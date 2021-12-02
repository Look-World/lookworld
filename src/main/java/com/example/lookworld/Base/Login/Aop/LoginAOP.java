package com.example.lookworld.Base.Login.Aop;


import com.example.lookworld.My.MyRuturn.R;
import com.example.lookworld.My.MyUtils.RedisUtil;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoginAOP {

    @Autowired
    RedisUtil redisUtil;


    @Pointcut("execution(* com.example.lookworld.*.*.Controller.*.*(..)) && !execution(* com.example.lookworld.Base.Login.Controller.UserController.login(..))")
    public void  verify(){

    }

    @Around("verify()")
    public Object  verifyLogin(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
            String uuid = (String) proceedingJoinPoint.getArgs()[0];
            Boolean isLogin =  redisUtil.hasKey(uuid);
            if(isLogin == false){
                return R.error("未登录");
            }
            String interfaceName =proceedingJoinPoint.getSignature().toShortString();



















            return proceedingJoinPoint.proceed();

    }


}
