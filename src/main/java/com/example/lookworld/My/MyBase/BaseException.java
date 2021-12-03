package com.example.lookworld.My.MyBase;


import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.example.lookworld.My.MyRuturn.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;


/**
 * 全局异常处理
 */
@RestControllerAdvice
public class BaseException {

    private Logger logger = LoggerFactory.getLogger(getClass());

    /**
     * 方法参数校验
     */
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public R handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        logger.warn("参数验证失败", e);
        return R.error("方法参数校验异常");
    }

    /**
     * 空指针异常
     */
    @ExceptionHandler({NullPointerException.class})
    public R NullPointerException(NullPointerException e) {
        logger.warn("空指针异常",e);
        return R.fail("空指针异常");
    }


    /**
     * 参数绑定失败
     * @param e
     * @return
     */
    @ExceptionHandler({BindException.class})
    public R handleError(BindException e) {
        logger.error("Spring通用检查参数校验不通过。BindException ->{}",e);
        List<ObjectError> objectErrorList = e.getAllErrors();
        List<String> errorMessageList = new ArrayList<>();
        if(CollectionUtils.isNotEmpty(objectErrorList)){
            //错误非空
            for(ObjectError error : objectErrorList){
                errorMessageList.add(error.getDefaultMessage());
            }
        }
        return R.fail(errorMessageList.toString());
    }

    /**
     * 方法参数校验
     */
    @ExceptionHandler({Exception.class})
    public R handleException(Exception e) {
        logger.error(e.getMessage(), e);
        return  R.error( "系统繁忙,请稍后再试");
    }


}
