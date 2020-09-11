package com.who.otherlanguageservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@RestController
public class TestController {
    /**
     * 其他服务.
     *
     * @return otherService
     */
    @GetMapping("/otherService")
    public String list() {
        return "otherService";
    }

}
