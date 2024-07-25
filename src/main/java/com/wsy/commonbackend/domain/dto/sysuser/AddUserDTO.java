package com.wsy.commonbackend.domain.dto.sysuser;

import lombok.Data;

import java.io.Serializable;

/**
 * 新增用户请求类
 *
 * @author wangshengyu
 */
@Data
public class AddUserDTO implements Serializable {

    /**
     * 用户账号
     */
    private String userAccount;

    /**
     * 用户密码
     */
    private String password;

    /**
     * 用户昵称
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String userEmail;

    /**
     * 用户电话
     */
    private String userPhone;

    /**
     * 用户地址
     */
    private String userAddress;

    /**
     * 用户简介
     */
    private String userProfile;

    /**
     * 用户权限 0 - 普通用户 1 - 管理员
     */
    private Integer userRole;

    private static final long serialVersionUID = 1L;
}
