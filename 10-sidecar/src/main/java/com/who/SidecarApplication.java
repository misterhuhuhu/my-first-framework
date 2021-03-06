package com.who;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.sidecar.EnableSidecar;

/**
 * 专门用于把第三方服务注册进eureka的服务
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@SpringBootApplication
@EnableSidecar
public class SidecarApplication {

    public static void main(final String[] args) {
        SpringApplication.run(SidecarApplication.class, args);
    }

}
