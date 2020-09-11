package com.who.controller;


import com.who.entity.Customer;
import com.who.stream.StreamClient;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 测试rabbitMQ
 *
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@RestController
public final class StreamController {

    @Resource
    private StreamClient streamClient;


    /**
     * 测试rabbitmq.
     *
     * @return Customer
     */
    @GetMapping("/send")
    public String send() {
        final int id = 1;
        final int age = 23;
        streamClient.output()
                .send(MessageBuilder
                        .withPayload(new Customer(id, "张三", age)).build());
        return "消息发送成功！！";
    }
}
