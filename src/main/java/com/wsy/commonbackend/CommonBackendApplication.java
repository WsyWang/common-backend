package com.wsy.commonbackend;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan("com.wsy.commonbackend.mapper")
@EnableAspectJAutoProxy
public class CommonBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(CommonBackendApplication.class, args);
    }

}
