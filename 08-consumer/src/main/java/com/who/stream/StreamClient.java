package com.who.stream;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.SubscribableChannel;


/**
 * 监听接口
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
public interface StreamClient {
    /**
     * 测试RabbitMQ
     *
     * @return null
     */
    @Input("mLine")
    SubscribableChannel input();
}
