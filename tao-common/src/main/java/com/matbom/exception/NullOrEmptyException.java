package com.matbom.exception;

public class NullOrEmptyException extends Exception {

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public NullOrEmptyException() {
        setMessage("参数不能为空!");
    }

    public NullOrEmptyException(String message) {
        this.message = message;
    }
}
