package com.who.client.fallback;

import javax.annotation.Resource;

import com.who.client.ConsumerClient;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;


/**
 * 降级工程,使调用方可以知道服务哪里出错.
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:42
 */
@Component
public final class ConsumerClientFallBackFactory implements FallbackFactory<ConsumerClient> {

    @Resource
    private ConsumerClientFallBack consumerClientFallBack;

    @Override
    public ConsumerClient create(final Throwable throwable) {
        throwable.printStackTrace();
        return consumerClientFallBack;
    }
}
