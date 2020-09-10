package com.who.listener;

import com.rabbitmq.client.Channel;
import com.who.stream.StreamClient;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

import java.io.IOException;


/**
 * 绑定监听接口
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@Component
@EnableBinding(StreamClient.class)
public class StreamReceiver {

    /**
     * 测试mq
     * @param msg 消息
     * @throws IOException 无
     */
    @StreamListener("mLine")
    public void msg(Object msg)  {
        System.out.println("接收到消息： " + msg);
    }
}
