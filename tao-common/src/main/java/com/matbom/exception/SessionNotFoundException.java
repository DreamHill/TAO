package com.matbom.exception;

public class SessionNotFoundException extends Exception {

    protected String message;

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public SessionNotFoundException() {
        setMessage("登录失效，请重新登录。");
    }

    public SessionNotFoundException(String message) {
        this.message = message;
    }
}