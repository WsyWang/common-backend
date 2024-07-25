package com.wsy.commonbackend.service.impl;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import com.wsy.commonbackend.common.ErrorCode;
import com.wsy.commonbackend.constants.ComConstant;
import com.wsy.commonbackend.domain.dto.IdDTO;
import com.wsy.commonbackend.domain.dto.sysuser.AddUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.QueryUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.UpdateUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.UserLoginDTO;
import com.wsy.commonbackend.domain.entity.SysUser;
import com.wsy.commonbackend.domain.vo.sysuser.UserInfoVO;
import com.wsy.commonbackend.exception.BaseException;
import com.wsy.commonbackend.mapper.SampleMapper;
import com.wsy.commonbackend.service.SampleService;
import com.wsy.commonbackend.utils.EncryptUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

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

    @Override
    public UserInfoVO login(UserLoginDTO userLoginDTO, HttpServletRequest request) {
        String userAccount = userLoginDTO.getUserAccount();
        String password = userLoginDTO.getPassword();
        SysUser sysUser = new SysUser();
        //1.校验参数
        if (StrUtil.hasBlank(userAccount, password)) {
            throw new BaseException(ErrorCode.ERROR_NULL_PARAMS);
        }
        if (StrUtil.hasEmpty(userAccount, password)) {
            throw new BaseException(ErrorCode.ERROR_NULL_PARAMS);
        }
        //2.密码加密
        String encryptPwd = EncryptUtil.encryptPasswordByMD5(password, salt);
        userLoginDTO.setPassword(encryptPwd);
        BeanUtils.copyProperties(userLoginDTO, sysUser);
        //3.查询用户
        UserInfoVO userInfoVO = sampleMapper.login(sysUser);
        //4.存到session
        if (userInfoVO == null) {
            throw new BaseException(ErrorCode.ERROR_LOGIN, "用户名或密码错误");
        }
        request.getSession().setAttribute(ComConstant.LOGIN_USER, userInfoVO);
        //5.返回封装用户
        return userInfoVO;
    }

    @Override
    public UserInfoVO getLoginUser(HttpServletRequest request) {
        Object loginUser = request.getSession().getAttribute(ComConstant.LOGIN_USER);
        if (loginUser == null) {
            throw new BaseException(ErrorCode.ERROR_NOT_LOGIN);
        }
        UserInfoVO userInfoVO = new UserInfoVO();
        BeanUtils.copyProperties(loginUser, userInfoVO);
        return userInfoVO;
    }

    @Override
    public Boolean deleteUser(IdDTO idDTO) {
        Long id = idDTO.getId();
        //1.校验
        if (id == null || id <= 0) {
            throw new BaseException(ErrorCode.ERROR_NULL_PARAMS);
        }
        //2.删除
        int count = sampleMapper.deleteById(id);
        //3.验证是否删除成功
        if (count != 1) {
            throw new BaseException(ErrorCode.ERROR_OPERATION);
        }
        return true;
    }

    @Override
    public Boolean updateUser(UpdateUserDTO updateUserDTO) {
        Long id = updateUserDTO.getId();
        //1.校验参数
        if (id == null || id <= 0) {
            throw new BaseException(ErrorCode.ERROR_NULL_PARAMS);
        }
        //2.修改
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(updateUserDTO, sysUser);
        int count = sampleMapper.updateById(sysUser);
        //3.验证是否修改成功
        if (count != 1) {
            throw new BaseException(ErrorCode.ERROR_OPERATION);
        }
        return true;
    }

    @Override
    public List<UserInfoVO> queryUser(QueryUserDTO queryUserDTO) {
        //1.复制
        SysUser sysUser = new SysUser();
        BeanUtils.copyProperties(queryUserDTO, sysUser);
        //2.查询
        return sampleMapper.queryUser(sysUser);
    }
}
