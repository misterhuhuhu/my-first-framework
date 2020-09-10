package com.who.otherlanguageservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * 这个服务不进入eureka
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@SpringBootApplication
public class OtherLanguageServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(OtherLanguageServiceApplication.class, args);

    }
}
