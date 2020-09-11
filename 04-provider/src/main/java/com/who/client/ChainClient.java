package com.who.client;


import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * 测试调用链.
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:42
 */
@FeignClient(value = "node-a")
public interface ChainClient {

    /**
     * 不能使用RestTemplate调用,每次都是独立的请求,无法形成调用链.
     *
     * @return 测试zipkin调用链
     */
    @GetMapping("/chain")
    String list();
}
