package com.wsy.commonbackend.controller;

import com.wsy.commonbackend.common.BaseResponse;
import com.wsy.commonbackend.common.ErrorCode;
import com.wsy.commonbackend.common.ResultUtil;
import com.wsy.commonbackend.domain.dto.IdDTO;
import com.wsy.commonbackend.domain.dto.sysuser.AddUserDTO;
import com.wsy.commonbackend.exception.BaseException;
import com.wsy.commonbackend.service.SampleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

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

    //删
    @ApiOperation("删除用户")
    @PostMapping("/deleteUser")
    public BaseResponse<Boolean> deleteUser(@RequestBody IdDTO idDTO) {
        return null;
    }

    //改
    //查


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
