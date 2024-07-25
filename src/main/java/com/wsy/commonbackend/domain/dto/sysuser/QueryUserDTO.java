package com.wsy.commonbackend.domain.dto.sysuser;

import lombok.Data;

import java.io.Serializable;

/**
 * 查询用户请求类
 * @author wangshengyu
 */
@Data
public class QueryUserDTO implements Serializable {

    private static final long serialVersionUID = -6558278792625143116L;

    /**
     * 用户账号
     */
    private String userAccount;

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
     * 用户权限 0 - 普通用户 1 - 管理员
     */
    private Integer userRole;

    /**
     * 用户状态 0 - 无效 1 - 有效
     */
    private Integer userStatus;

}
