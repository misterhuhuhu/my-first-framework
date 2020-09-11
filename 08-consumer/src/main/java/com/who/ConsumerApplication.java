package com.who;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 这个是消费者服务.
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@SpringBootApplication
@EnableEurekaClient
public class ConsumerApplication {
    public static void main(final String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
