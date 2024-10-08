package com.kevin.enums;

import lombok.Getter;

@Getter
public enum UserStatus {
    NORMAL(1, "正常"),
    FROZEN(2, "冻结"),
    ;
    private final int value;
    private final String desc;
    UserStatus(int value, String desc){
        this.value = value;
        this.desc = desc;
    }
}
