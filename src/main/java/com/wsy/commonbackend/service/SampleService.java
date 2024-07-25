package com.wsy.commonbackend.service;

import com.wsy.commonbackend.domain.dto.IdDTO;
import com.wsy.commonbackend.domain.dto.sysuser.AddUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.QueryUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.UpdateUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.UserLoginDTO;
import com.wsy.commonbackend.domain.vo.sysuser.UserInfoVO;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    /**
     * 用户登录
     * @param userLoginDTO 用户登录封装类
     * @param request 请求
     * @return 用户信息封装类
     */
    UserInfoVO login(UserLoginDTO userLoginDTO, HttpServletRequest request);

    /**
     * 获取当前登录用户
     * @param request 携带session的请求
     * @return 用户信息封装类
     */
    UserInfoVO getLoginUser(HttpServletRequest request);

    /**
     * 删除用户
     * @param idDTO id请求类
     * @return 是否删除成功
     */
    Boolean deleteUser(IdDTO idDTO);

    /**
     * 修改用户
     * @param updateUserDTO 修改用户请求类
     * @return 是否修改成功
     */
    Boolean updateUser(UpdateUserDTO updateUserDTO);

    /**
     * 查询用户
     * @param queryUserDTO 查询用户封装类
     * @return 用户信息封装类列表
     */
    List<UserInfoVO> queryUser(QueryUserDTO queryUserDTO);
}
