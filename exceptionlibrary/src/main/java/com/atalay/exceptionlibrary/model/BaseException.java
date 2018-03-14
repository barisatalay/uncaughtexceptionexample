package com.atalay.exceptionlibrary.model;

/**
 * Created by barisatalay on 14.03.2018.
 */

public class BaseException extends Error{
    private ExceptionType type;

    public BaseException(String message, ExceptionType exceptionType) {
        super(message);
        setType(exceptionType);
    }

    public ExceptionType getType() {
        return type;
    }

    public BaseException setType(ExceptionType type) {
        this.type = type;
        return this;
    }
}
