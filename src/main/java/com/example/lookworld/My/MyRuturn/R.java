package com.example.lookworld.My.MyRuturn;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

import static com.example.lookworld.My.MyRuturn.ResultEnum.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R<T> implements Serializable {
    private Integer code;

    private String msg;

    private T data;

    public R(Integer code){
        this.code = code;
    }



    //成功时调用
    public static <T> R<T> success(){
        return success(RESPONSE2);
    }
    public static <T> R<T> success(ResultEnum re){
        return success(re,null);
    }
    public static <T> R<T> success(T data){
        return success(RESPONSE1,data);
    }
    public static <T> R<T> success(ResultEnum re,T data){
        Integer code = re.getCode();
        String msg = re.getMsg();
        return success(code,msg,data);
    }
    public static <T> R<T> success(String msg, T data){
        R<T> result = new R<>(1000);
        result.setCode(RESPONSE1.getCode());
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public static <T> R<T> success(Integer code, String msg, T data){
        R<T> result = new R<>(1000);
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    //错误时时调用
    public static <T> R<T> error(){
        return error(RESPONSE10);
    }
    public static <T> R<T> error(ResultEnum re){
        return error(re,null);
    }
    public static <T> R<T> error(String msg){
        return error(RESPONSE10.getCode(),msg,null);
    }
    public static <T> R<T> error(T data){
        return error(RESPONSE10,data);
    }
    public static <T> R<T> error(ResultEnum re, T data){
        Integer code = re.getCode();
        String msg = re.getMsg();
        return error(code,msg,data);
    }
    public static <T> R<T> error(Integer code , String msg, T data){
        R<T> result = new R<>();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
    public static <T> R<T> NotFound(){
        R<T> result = new R<>(1000);
        result.setCode(RESPONSE4.getCode());
        result.setMsg(RESPONSE4.getMsg());
        return result;
    }

    //失败时调用：
    public static <T> R<T> fail(String msg) {
        return  R.fail(RESPONSE3.getCode(), msg);
    }
    public static <T> R<T> fail(int code, String msg) {
        R<T> result = new R<>(1000);
        result.setCode(code);
        result.setMsg(msg);
        return result;
    }



}
