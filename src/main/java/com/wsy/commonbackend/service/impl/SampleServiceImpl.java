package com.wsy.commonbackend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.wsy.commonbackend.common.ErrorCode;
import com.wsy.commonbackend.domain.dto.sysuser.AddUserDTO;
import com.wsy.commonbackend.domain.entity.SysUser;
import com.wsy.commonbackend.exception.BaseException;
import com.wsy.commonbackend.mapper.SampleMapper;
import com.wsy.commonbackend.service.SampleService;
import com.wsy.commonbackend.utils.EncryptUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author wangshengyu
 */
@Service
public class SampleServiceImpl implements SampleService {

    @Value("${salt}")
    private String salt;

    @Resource
    private SampleMapper sampleMapper;

    @Override
    public Boolean addUser(AddUserDTO addUserDTO) {
        String userAccount = addUserDTO.getUserAccount();
        String password = addUserDTO.getPassword();
        String userName = addUserDTO.getUserName();
        SysUser sysUser = new SysUser();
        //1.校验
        if (StrUtil.hasBlank(userAccount, password, userName)) {
            throw new BaseException(ErrorCode.ERROR_NULL_PARAMS);
        }
        if (StrUtil.hasEmpty(userAccount, password, userName)) {
            throw new BaseException(ErrorCode.ERROR_NULL_PARAMS);
        }
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_account", userAccount);
        if (sampleMapper.exists(queryWrapper)) {
            throw new BaseException(ErrorCode.ERROR_OPERATION, "已有相同账户");
        }
        //2.加密密码
        String encryptPwd = EncryptUtil.encryptPasswordByMD5(password, salt);
        addUserDTO.setPassword(encryptPwd);
        BeanUtils.copyProperties(addUserDTO, sysUser);
        //3.新建id
        long id = IdWorker.getId();
        sysUser.setId(id);
        //4.插入
        int count = sampleMapper.addUser(sysUser);
        //5.验证是否插入成功
        if (count != 1) {
            throw new BaseException(ErrorCode.ERROR_OPERATION);
        }
        return true;
    }
}
