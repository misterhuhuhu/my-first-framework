package com.who.controller;

import com.who.client.ChainClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试zipkin链路追踪.
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@RestController
public final class TestController {

    @Resource
    private ChainClient chainClient;

    /**
     * 测试zipkin链路追踪.
     * @return test chain
     */
    @GetMapping("/chain")
    public String list() {

        return chainClient.list();
    }
}
