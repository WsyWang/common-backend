package com.wsy.commonbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wsy.commonbackend.domain.entity.SysUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

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
}
