package com.wsy.commonbackend.domain.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * 只传入id的通用请求类
 *
 * @author wangshengyu
 */
@Data
public class IdDTO implements Serializable {

    /**
     * id
     */
    private Long id;

    private static final long serialVersionUID = 7504365365564470254L;
}
