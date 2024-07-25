package com.wsy.commonbackend.controller;

import com.wsy.commonbackend.annotations.AuthCheck;
import com.wsy.commonbackend.common.BaseResponse;
import com.wsy.commonbackend.common.ErrorCode;
import com.wsy.commonbackend.common.ResultUtil;
import com.wsy.commonbackend.constants.ComConstant;
import com.wsy.commonbackend.domain.dto.IdDTO;
import com.wsy.commonbackend.domain.dto.sysuser.AddUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.QueryUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.UpdateUserDTO;
import com.wsy.commonbackend.domain.dto.sysuser.UserLoginDTO;
import com.wsy.commonbackend.domain.vo.sysuser.UserInfoVO;
import com.wsy.commonbackend.exception.BaseException;
import com.wsy.commonbackend.service.SampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 控制器示例
 *
 * @author wangshengyu
 */
@Api(tags = "示例接口")
@RestController
@RequestMapping("/sample")
public class SampleController {

    @Resource
    private SampleService sampleService;

    /**
     * 新增用户示例接口
     *
     * @param addUserDTO 新增用户请求类
     * @return 是否新增成功
     */
    @ApiOperation("新增用户")
    @PostMapping("/addUser")
    public BaseResponse<Boolean> addUser(@RequestBody AddUserDTO addUserDTO) {
        return ResultUtil.success(sampleService.addUser(addUserDTO));
    }

    /**
     * 删除用户
     * @param idDTO id请求类
     * @return 是否删除成功
     */
    @AuthCheck(auth = {ComConstant.ADMIN_USER})
    @ApiOperation("删除用户")
    @PostMapping("/deleteUser")
    public BaseResponse<Boolean> deleteUser(@RequestBody IdDTO idDTO) {
        return ResultUtil.success(sampleService.deleteUser(idDTO));
    }

    /**
     * 修改用户
     * @param updateUserDTO 修改用户请求类
     * @return 是否修改成功
     */
    @AuthCheck(auth = {ComConstant.ADMIN_USER})
    @ApiOperation("修改用户")
    @PostMapping("/updateUser")
    public BaseResponse<Boolean> updateUser(@RequestBody UpdateUserDTO updateUserDTO) {
        return ResultUtil.success(sampleService.updateUser(updateUserDTO));
    }

    /**
     * 查询用户
     * @param queryUserDTO 查询用户封装类
     * @return 用户信息封装类列表
     */
    @AuthCheck(auth = {ComConstant.ADMIN_USER})
    @ApiOperation("查询用户")
    @PostMapping("/queryUser")
    public BaseResponse<List<UserInfoVO>> queryUser(@RequestBody QueryUserDTO queryUserDTO) {
        return ResultUtil.success(sampleService.queryUser(queryUserDTO));
    }

    /**
     * 用户登录
     * @param userLoginDTO 用户登录封装类
     * @param request 请求
     * @return 用户信息封装类
     */
    @ApiOperation("用户登录")
    @PostMapping("/login")
    public BaseResponse<UserInfoVO> login(@RequestBody UserLoginDTO userLoginDTO, HttpServletRequest request) {
        return ResultUtil.success(sampleService.login(userLoginDTO, request));
    }

    /**
     * 获取当前登录用户
     * @param request 携带session的请求
     * @return 用户信息封装类
     */
    @ApiOperation("获取当前登录用户")
    @PostMapping("/getLoginUser")
    public BaseResponse<UserInfoVO> getLoginUser(HttpServletRequest request) {
        return ResultUtil.success(sampleService.getLoginUser(request));
    }

    /**
     * 测试成功状态下的基本返回类型
     *
     * @return 基本返回类型
     */
    @ApiOperation("测试成功请求")
    @GetMapping("/success")
    public BaseResponse<String> testSuccess() {
        return ResultUtil.success("success");
    }

    /**
     * 测试失败状态下的基本返回类型
     *
     * @return 无
     */
    @ApiOperation("测试失败请求")
    @GetMapping("/error")
    public String testError() {
        throw new BaseException(ErrorCode.ERROR_OPERATION, "测试失败请求");
    }
}
