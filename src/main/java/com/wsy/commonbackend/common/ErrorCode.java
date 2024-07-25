package com.wsy.commonbackend.common;

import lombok.Getter;

/**
 * 错误码枚举类
 *
 * @author wangshengyu
 */
@Getter
public enum ErrorCode {
    SUCCESS(0, "ok"),
    ERROR_NULL_PARAMS(400001, "参数为空"),
    ERROR_AUTH(400002, "无权限"),
    ERROR_OPERATION(400003, "操作失败"),
    ERROR_NOT_LOGIN(400004, "未登录"),
    ERROR_LOGIN(400005, "登录失败"),
    ERROR_SYSTEM(500001, "系统错误"),
    ;

    private final Integer code;

    private final String message;

    ErrorCode(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
