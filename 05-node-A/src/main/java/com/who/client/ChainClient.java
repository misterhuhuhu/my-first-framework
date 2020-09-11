package com.who.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author 胡昊宁
 * @date 2020/9/10 8:42
 */
@FeignClient(value = "node-b")
public interface ChainClient {
    /**
     * 测试链路追踪.
     * @return test
     */
    @GetMapping("/chain")
    String list();
}
