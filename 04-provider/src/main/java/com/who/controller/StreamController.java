package com.who.controller;


import com.who.entity.Customer;
import com.who.stream.StreamClient;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@RestController
public class StreamController {

    @Resource
    private StreamClient streamClient;


    @GetMapping("/send")
    public String send(){
        streamClient.output().send(MessageBuilder.withPayload(new Customer(1,"张三",23)).build());
        return "消息发送成功！！";
    }
}
