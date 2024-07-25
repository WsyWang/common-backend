package com.wsy.commonbackend.exception;

import com.wsy.commonbackend.common.ErrorCode;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 基础异常类
 *
 * @author wangshengyu
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseException extends RuntimeException {

    private final Integer code;

    private String message;

    public BaseException(Integer code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public BaseException(ErrorCode errorCode, String message) {
        super(message);
        this.message = message;
        this.code = errorCode.getCode();
    }

    public BaseException(ErrorCode errorCode) {
        super(errorCode.getMessage());
        this.message = errorCode.getMessage();
        this.code = errorCode.getCode();
    }

}
