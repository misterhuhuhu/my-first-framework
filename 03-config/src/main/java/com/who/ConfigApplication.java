package com.who;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;

/**
 * 这是动态配置服务.
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:42
 */
@SpringBootApplication
@EnableDiscoveryClient
@EnableConfigServer
public class ConfigApplication {

    public static void main(final String[] args) {
        SpringApplication.run(ConfigApplication.class, args);
    }

}
