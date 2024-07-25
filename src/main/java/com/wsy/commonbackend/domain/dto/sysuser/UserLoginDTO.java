package com.wsy.commonbackend.domain.dto.sysuser;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户登录请求类
 *
 * @author wangshengyu
 */
@Data
public class UserLoginDTO implements Serializable {

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String password;

    private static final long serialVersionUID = 1L;
}
