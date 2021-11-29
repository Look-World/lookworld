package com.example.lookworld.My.MyConfig;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class MyBatisPlusConfig implements MetaObjectHandler {
    @Override
    public void insertFill(MetaObject metaObject) {

        setFieldValByName("isDelete",0,metaObject);

        setFieldValByName("createUser",new Date(),metaObject);
        setFieldValByName("createTime",new Date(),metaObject);

    }

    @Override
    public void updateFill(MetaObject metaObject) {

        setFieldValByName("updateUser",new Date(),metaObject);
        setFieldValByName("updateTime",new Date(),metaObject);

//        Object isDeleted =getFieldValByName("isDelete",metaObject);
//        if (isDeleted != null){
//            setFieldValByName("deleteTime",new Date(),metaObject);
//        }

    }
}
