package com.example.lookworld.My.MyRuturn;


public enum ResultEnum {

    //成功状态码
    RESPONSE1(200, "成功"),
    RESPONSE2(204,"成功，但没有数据返回"),

    //失败状态码
    RESPONSE3(400,"请求失败，请求的参数或内容存在错误或缺失"),
    RESPONSE4(404,"请求路径未找到"),
    RESPONSE5(405,"请求方法不允许"),
    RESPONSE6(406,"请求资源不匹配"),
    RESPONSE7(408,"请求超时"),
    RESPONSE8(413,"返回结果超过服务器缓存"),
    RESPONSE9(429,"请求过多过快导致被请求资源超限"),

    RESPONSE10(500,"服务器内部错误"),
    RESPONSE11(501,"功能未实现"),
    RESPONSE12(503,"服务器资源不足"),
    ;

    private Integer code;
    private String msg;

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    ResultEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
