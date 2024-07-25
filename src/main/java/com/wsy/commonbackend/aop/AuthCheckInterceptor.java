package com.wsy.commonbackend.aop;

import com.wsy.commonbackend.annotations.AuthCheck;
import com.wsy.commonbackend.common.ErrorCode;
import com.wsy.commonbackend.constants.ComConstant;
import com.wsy.commonbackend.domain.vo.sysuser.UserInfoVO;
import com.wsy.commonbackend.exception.BaseException;
import com.wsy.commonbackend.service.SampleService;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 权限检查AOP
 *
 * @author wangshengyu
 */
@Aspect
@Component
public class AuthCheckInterceptor {

    @Resource
    private SampleService sampleService;

    @Around("@annotation(authCheck)")
    public Object authCheck(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        int[] auth = authCheck.auth();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        UserInfoVO loginUser = sampleService.getLoginUser(request);
        //1.如果当前登录用户不存在
        if (loginUser == null) {
            throw new BaseException(ErrorCode.ERROR_NOT_LOGIN);
        }
        //2.如果当前用户被封号
        if (loginUser.getUserStatus() == ComConstant.BAN) {
            throw new BaseException(ErrorCode.ERROR_AUTH);
        }
        boolean hasAuth = false;
        for (int i : auth) {
            if (loginUser.getUserRole() == i) {
                hasAuth = true;
                break;
            }
        }
        //3.如果当前用户权限不足
        if (!hasAuth) {
            throw new BaseException(ErrorCode.ERROR_AUTH);
        }
        return joinPoint.proceed();
    }

}



















