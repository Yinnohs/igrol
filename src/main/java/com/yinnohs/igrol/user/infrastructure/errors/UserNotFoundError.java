package com.yinnohs.igrol.user.infrastructure.errors;

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
