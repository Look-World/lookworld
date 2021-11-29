package com.example.lookworld.My.MyBase;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.example.lookworld.Base.Login.Server.UserServer;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class BaseEntryFillConfig implements MetaObjectHandler {

    @Override
    public void insertFill(MetaObject metaObject) {

        setFieldValByName("isDelete",0,metaObject);

        Long id = (Long) getFieldValByName("id",metaObject);
        setFieldValByName("createUser",id,metaObject);
        setFieldValByName("createTime",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {

        Long id = (Long) getFieldValByName("id",metaObject);
        setFieldValByName("updateUser",id,metaObject);
        setFieldValByName("updateTime",new Date(),metaObject);


    }
}
