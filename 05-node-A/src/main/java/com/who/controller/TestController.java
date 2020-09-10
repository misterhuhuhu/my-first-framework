package com.who.controller;

import com.who.client.ChainClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


/**
 * @author 胡昊宁
 * @date 2020/9/9 23:01
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