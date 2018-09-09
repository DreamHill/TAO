package com.matbom.resourcesservice.controller;

import com.matbom.exception.IllegalPropertiesException;
import com.matbom.exception.NullOrEmptyException;
import com.matbom.exception.SessionNotFoundException;
import com.matbom.utils.ResponseResult;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(SessionNotFoundException.class)
    @ResponseBody
    public ResponseResult<String> sessionNotFoundExceptionHandler(HttpServletRequest request, SessionNotFoundException exception) throws Exception {
        ResponseResult rst=new ResponseResult();
        rst.setCode("403");
        rst.setMessage( exception.getMessage());
        rst.setData(exception);
        return rst;
    }

    @ExceptionHandler(NullOrEmptyException.class)
    @ResponseBody
    public ResponseResult<String> nullOrEmptyExceptionHandler(HttpServletRequest request, NullOrEmptyException exception) throws Exception {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(IllegalPropertiesException.class)
    @ResponseBody
    public ResponseResult<String> illegalPropExceptionHandler(HttpServletRequest request, IllegalPropertiesException exception) throws Exception {

        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResult<String> exceptionHandler(HttpServletRequest request, Exception exception) throws Exception {
        return handleErrorInfo(request, exception.getMessage(), exception);
    }

    private ResponseResult<String> handleErrorInfo(HttpServletRequest request, String message, Exception exception) {
        ResponseResult rst=new ResponseResult();
        rst.setCode("500");
        rst.setMessage( exception.getMessage());
        rst.setData(exception);
        return rst;
    }
}