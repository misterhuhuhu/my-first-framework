package com.who.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试zipkin链路追踪的接口
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@FeignClient(value = "consumer")
public interface ChainClient {
    /**
     * 测试链路追踪.
     *
     * @return test
     */
    @GetMapping("/chain")
    String list();
}
