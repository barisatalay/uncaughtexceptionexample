package com.atalay.exceptionlibrary.model;

/**
 * Created by barisatalay on 14.03.2018.
 */

public enum  ExceptionType {
    Error (1), Success(2), Information(3), Warning(4);
    private int value;

    ExceptionType(int value) {
        this.value = value;
    }
    public int id(){
        return value;
    }

    public static ExceptionType fromId(int value) {
        for(ExceptionType item : values()) {
            if (item.value == value) {
                return item;
            }
        }
        return null;
    }
}
