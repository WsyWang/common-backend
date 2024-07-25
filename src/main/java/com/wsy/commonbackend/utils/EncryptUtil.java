package com.wsy.commonbackend.utils;

import cn.hutool.crypto.digest.MD5;

/**
 * 加密工具类
 *
 * @author wangshengyu
 */
public class EncryptUtil {

    private EncryptUtil() {
    }

    public static String encryptPasswordByMD5(String password, String salt) {
        return MD5.create().digestHex(password + salt);
    }

}
