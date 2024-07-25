package com.wsy.commonbackend.common;

/**
 * 基本返回工具类
 *
 * @author wangshengyu
 */
public class ResultUtil {

    /**
     * 只提供静态方法
     */
    private ResultUtil() {
    }

    /**
     * 成功
     *
     * @param data 数据
     * @param <T>  数据类型
     * @return 基本返回类型
     */
    public static <T> BaseResponse<T> success(T data) {
        return new BaseResponse<>(ErrorCode.SUCCESS, data);
    }

    /**
     * 失败
     *
     * @param errorCode 状态码
     * @param <T>       数据类型
     * @return 基本返回类型
     */
    public static <T> BaseResponse<T> error(ErrorCode errorCode) {
        return new BaseResponse<>(errorCode, null);
    }

    /**
     * 失败
     *
     * @param code    状态码
     * @param message 消息
     * @param <T>     数据类型
     * @return 基本返回类型
     */
    public static <T> BaseResponse<T> error(Integer code, String message) {
        return new BaseResponse<>(code, message);
    }
}
