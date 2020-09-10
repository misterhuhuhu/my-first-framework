package com.who.controller;

import com.who.entity.Customer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.Random;

/**
 * @author 胡昊宁
 * @date 2020/9/10 8:43
 */
@RestController
public class ConsumerController {
    @GetMapping("/consumer")
    public String consumer() {
        return "consumer";
    }

    @Value("${server.port}")
    private String port;

    /**
     * 测试robbin,无参数
     *
     * @return consumer的端口号
     */
    @GetMapping("/port")
    public String port() {
        return "port:" + port;
    }

    /**
     * 测试robbin传参
     *
     * @param id 任意数字
     * @return 返回模拟的customer
     */
    @GetMapping("/search/{id}")
    public Customer findById(@PathVariable Integer id) {
        return new Customer(id, "张三  " + "port:" + port, (new Random()).nextInt());
    }

    /**
     * 模仿feign传两个参数
     *
     * @param id   任意数字
     * @param name 非符号字符串
     * @return 返回模拟的customer
     */
    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name) {
        return new Customer(id, name + "  port:" + port, 23);
    }

    /**
     * Feign再传递复杂参数时自动转换为POST
     *
     * @param customer 模拟使用post传值的customer
     * @return 模拟使用post传值的customer
     */
    @PostMapping("/save")
    public Customer save(@RequestBody Customer customer) {
        return customer;
    }

    /**
     * 模拟运行时错误
     *
     * @return 无
     */
    @GetMapping("/error")
    public String simulateError() {
        throw new RuntimeException("手动报错");
    }

    @GetMapping("/chain")
    public String chain() {

        return "test chain";
    }
}
