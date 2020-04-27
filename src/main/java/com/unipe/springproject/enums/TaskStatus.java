package com.unipe.springproject.enums;

public enum TaskStatus {

    OPEN(1), CLOSED(0);

    private int code;

    TaskStatus(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }
}
