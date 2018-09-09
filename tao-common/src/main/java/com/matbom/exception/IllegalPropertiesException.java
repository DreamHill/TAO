package com.matbom.exception;

public class IllegalPropertiesException extends Exception {
    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    protected String message;

    public IllegalPropertiesException() {
        setMessage("参数不合法！");
    }

    public IllegalPropertiesException(String message) {
        this.message = message;
        setMessage(String.format("Prop: %s is illegal!", message));
    }
}