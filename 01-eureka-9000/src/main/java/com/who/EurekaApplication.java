package com.who;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * @author 胡昊宁
 * @date 2020/9/10 8:42
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaApplication {
    public static void main(final String[] args) {
        SpringApplication.run(EurekaApplication.class, args);
    }
}
