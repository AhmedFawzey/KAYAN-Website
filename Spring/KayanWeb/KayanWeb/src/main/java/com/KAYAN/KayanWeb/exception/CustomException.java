package com.KAYAN.KayanWeb.exception;

public class CustomException extends RuntimeException {
    private String msg;

    public CustomException(String msg) {
        super(msg);
        this.msg = msg;
    }
    @Override
    public String getMessage() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
