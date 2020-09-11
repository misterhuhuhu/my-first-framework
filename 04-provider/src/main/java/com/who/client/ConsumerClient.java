package com.who.client;

import com.who.client.fallback.ConsumerClientFallBackFactory;
import com.who.entity.Customer;
import org.springframework.cloud.openfeign.FeignClient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * FeignClient 自动有负载均衡.
 * 用于测试Feign
 *
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@FeignClient(value = "consumer", fallbackFactory = ConsumerClientFallBackFactory.class)
public interface ConsumerClient {
    /**
     * 无参数GET.
     *
     * @return null
     */
    @GetMapping("/consumer")
    String consumer();

    /**
     * 无参数GET.
     *
     * @return null
     */
    @GetMapping("/port")
    String port();


    /**
     * 测试feign传参.
     *
     * @param id 任意数字
     * @return 带有数字的字符串
     */
    @GetMapping("/consumer/{id}")
    Customer findById(@PathVariable(value = "id") Integer id);

    /**
     * 多个参数GET.
     *
     * @param id   任意数字
     * @param name 任意非符号字符串
     * @return null
     */
    @GetMapping("/consumer")
    Customer getCustomer(@RequestParam(value = "id") Integer id,
                         @RequestParam(value = "name") String name);

    /**
     * 一个参数.
     *
     * @param customer 任意
     * @return null
     */
    @PostMapping("/save")
    Customer save(@RequestBody Customer customer);

    /**
     * 测试feign与hytrix 降级.
     *
     * @return 1
     */
    @GetMapping("/error")
    String simulateError();
}
