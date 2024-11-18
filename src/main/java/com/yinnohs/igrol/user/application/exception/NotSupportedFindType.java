package com.yinnohs.igrol.user.application.exception;

public class NotSupportedFindType extends RuntimeException{
    public NotSupportedFindType(String message) {
        super(message);
    }

    public NotSupportedFindType(String message, Throwable cause) {
        super(message, cause);
    }

    public NotSupportedFindType(Throwable cause) {
        super(cause);
    }
}
