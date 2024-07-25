package com.wsy.commonbackend.common;

import lombok.Data;

/**
 * 基本返回封装类
 *
 * @author wangshengyu
 */
@Data
public class BaseResponse<T> {

    /**
     * 状态码
     */
    private Integer code;

    /**
     * 信息
     */
    private String message;

    /**
     * 数据
     */
    private T data;

    public BaseResponse(Integer code, String message, T data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public BaseResponse(Integer code, String message) {
        this(code, message, null);
    }

    public BaseResponse(ErrorCode errorCode, String message) {
        this(errorCode.getCode(), message, null);
    }

    public BaseResponse(ErrorCode errorCode, T data) {
        this(errorCode.getCode(), errorCode.getMessage(), data);
    }

    public BaseResponse(ErrorCode errorCode) {
        this(errorCode.getCode(), errorCode.getMessage(), null);
    }
}
