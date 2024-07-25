package com.wsy.commonbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsy.commonbackend.domain.entity.SysUser;
import com.wsy.commonbackend.domain.vo.sysuser.UserInfoVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangshengyu
 */
@Mapper
public interface SampleMapper extends BaseMapper<SysUser> {

    /**
     * 新增用户
     *
     * @param sysUser 用户实体类
     * @return 新增用户条数
     */
    int addUser(@Param("sysUser") SysUser sysUser);

    /**
     * 用户登录
     * @param sysUser 用户实体类
     * @return 用户信息封装类
     */
    UserInfoVO login(@Param("sysUser") SysUser sysUser);

    /**
     * 查询用户
     * @param sysUser 查询用户请求类
     * @return 用户信息封装类列表
     */
    List<UserInfoVO> queryUser(@Param("sysUser") SysUser sysUser);
}
