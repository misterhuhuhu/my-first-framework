package com.who.controller;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.who.client.ChainClient;
import com.who.client.ConsumerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@RestController
public class ChainController {


    @Resource
    private ChainClient chainClient;

    @GetMapping("/chain")
    public String list() {
        return chainClient.list();
    }
}
