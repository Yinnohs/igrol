package com.yinnohs.igrol.itemlist.domain.exception;

public class IteListNotFoundException extends RuntimeException{
    public IteListNotFoundException(String message) {
        super(message);
    }

    public IteListNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public IteListNotFoundException(Throwable cause) {
        super(cause);
    }
}
