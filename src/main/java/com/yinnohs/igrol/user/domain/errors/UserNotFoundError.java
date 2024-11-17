package com.yinnohs.igrol.user.domain.errors;

public class UserNotFoundError extends RuntimeException{
    public UserNotFoundError(String message) {
        super(message);
    }

    public UserNotFoundError(String message, Throwable cause) {
        super(message, cause);
    }

    public UserNotFoundError(Throwable cause) {
        super(cause);
    }
}
