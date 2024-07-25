package com.wsy.commonbackend.exception;

import com.wsy.commonbackend.common.BaseResponse;
import com.wsy.commonbackend.common.ErrorCode;
import com.wsy.commonbackend.common.ResultUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理
 *
 * @author wangshengyu
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public <T> BaseResponse<T> runtimeException(RuntimeException e) {
        log.error(e.getMessage(), e);
        return ResultUtil.error(ErrorCode.ERROR_SYSTEM);
    }

    @ExceptionHandler(BaseException.class)
    public <T> BaseResponse<T> baseException(BaseException e) {
        log.error(e.getMessage(), e);
        return ResultUtil.error(e.getCode(), e.getMessage());
    }

}
