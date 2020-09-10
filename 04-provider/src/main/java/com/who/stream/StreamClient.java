package com.who.stream;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;


/**
 * 声明一个mq的输出接口
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
public interface StreamClient {
    /**
     * RabbitMQ
     * @return null
     */
    @Output("mLine")
    MessageChannel output();

}
