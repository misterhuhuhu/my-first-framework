package com.who.controller;

import com.who.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@RestController
public final class ConsumerController {

    @Value("${server.port}")
    private String port;

    /**
     * 测试robbin,无参数.
     *
     * @return consumer的端口号
     */
    @GetMapping("/port")
    public String port() {
        return "port:" + port;
    }

    /**
     * 测试robbin传参.
     *
     * @param id 任意数字
     * @return 返回模拟的customer
     */
    @GetMapping("/customer/{id}")
    public Customer findById(@PathVariable final Integer id) {
        return new Customer(id,
                "张三  " + "port:" + port,
                (new Random()).nextInt());
    }

    /**
     * 模仿feign传两个参数.
     *
     * @param id   任意数字
     * @param name 非符号字符串
     * @return 返回模拟的customer
     */
    @GetMapping("/customer")
    public Customer getCustomer(@RequestParam final Integer id,
                                @RequestParam final String name) {
        final int age = 23;
        return new Customer(id, name + "  port:" + port, age);
    }

    /**
     * Feign再传递复杂参数时自动转换为POST.
     *
     * @param customer 模拟使用post传值的customer
     * @return 模拟使用post传值的customer
     */
    @PostMapping("/customer")
    public Customer save(@RequestBody final Customer customer) {
        return customer;
    }

    /**
     * 模拟运行时错误.
     *
     * @return 无
     */
    @GetMapping("/error")
    public String simulateError() {
        throw new RuntimeException("手动报错");
    }

    /**
     * 测试zipkin链路追踪.
     *
     * @return test chain
     */
    @GetMapping("/chain")
    public String chain() {

        return "test chain";
    }
}
