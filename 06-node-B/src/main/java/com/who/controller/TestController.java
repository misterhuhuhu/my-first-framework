package com.who.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.who.client.ChainClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * 测试zipkin链路追踪
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@RestController
public class TestController {

    @Resource
    private ChainClient chainClient;
    @GetMapping("/chain")
    public String list() {

        return chainClient.list();
    }
}
