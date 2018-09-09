package com.matbom.utils;

import java.io.Serializable;

/**
 * <p>输出格式</p>
 *
 * @author wangbingcheng
 * @version 1.0
 * @date 2017/3/17 15:47
 * @since 1.0
 */
public class ResponseResult<T> implements Serializable {

    private static final long serialVersionUID = 5586118057859274971L;

    
    private String code = "200";

    private String message;

    private T data;

    public ResponseResult() {
    }

    public ResponseResult(T data) {
        this.data = data;
    }

    public ResponseResult(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResponseResult(String code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static <T> ResponseResult buildSuccess(T data) {
        return new ResponseResult(data);
    }

    public static ResponseResult buildFail(String code, String message) {
        return new ResponseResult(code, message);
    }

    @Override
    public String toString() {
        return "ResultDto{" +
                "code=" + code +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
