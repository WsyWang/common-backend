package com.wsy.commonbackend.service;

import com.wsy.commonbackend.domain.dto.sysuser.AddUserDTO;

/**
 * 服务类示例
 *
 * @author wangshengyu
 */
public interface SampleService {

    /**
     * 新增用户示例接口
     *
     * @param addUserDTO 新增用户请求类
     * @return 是否新增成功
     */
    Boolean addUser(AddUserDTO addUserDTO);
}
