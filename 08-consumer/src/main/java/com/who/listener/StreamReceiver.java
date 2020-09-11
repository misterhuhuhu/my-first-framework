package com.who.listener;

import com.who.stream.StreamClient;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.stereotype.Component;


/**
 * 绑定监听接口.
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@Component
@EnableBinding(StreamClient.class)
@Slf4j
public class StreamReceiver {

    /**
     * 测试mq.
     * @param msg 消息
     */
    @StreamListener("mLine")
    public void msg(final Object msg)  {
        log.info("接收到消息： " + msg);
    }
}
