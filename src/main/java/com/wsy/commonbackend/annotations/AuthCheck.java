package com.wsy.commonbackend.annotations;

/**
 * 检查用户权限注解
 *
 * @author wangshengyu
 */
public @interface AuthCheck {

    int[] auth();
}
