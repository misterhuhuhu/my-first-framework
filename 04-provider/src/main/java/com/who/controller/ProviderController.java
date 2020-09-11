package com.who.controller;

import javax.annotation.Resource;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.who.client.ConsumerClient;
import com.who.entity.Customer;
import com.who.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


/**
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@RestController
@Slf4j
public class ProviderController {
    @Resource
    private RestTemplate restTemplate;

    @Resource
    private CustomerService customerService;

    @Resource
    private ConsumerClient consumerClient;

    @Value("${version}")
    private String version;

    /**
     * 测试robbin均衡负载.
     *
     * @return 被使用的consumer服务的端口号
     */
    @GetMapping("/portTest")
    public String port() {
        return restTemplate.getForObject("http://consumer/port", String.class);
    }


    /**
     * 测试robbin传参 测试//http://localhost:9500/search/1.
     *
     * @param id 任意数字
     * @return 返回模拟的customer
     */
    @GetMapping("/getCustomer/{id}")
    public Customer findById(@PathVariable final Integer id) {
        return consumerClient.findById(id);
    }

    /**
     * 测试feign传两个参数 测试//http://localhost:9500/getCustomer?id=1&name=xxx.
     *
     * @param id   任意数字
     * @param name 非符号字符串
     * @return 返回模拟的customer
     */
    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam final Integer id,
                                @RequestParam final String name) {
        return consumerClient.getCustomer(id, name);
    }

    /**
     * Feign再传递复杂参数时自动转换为POST.
     *
     * @param customer 模拟使用post传值的customer
     * @return 输入的customer
     */
    @GetMapping("/save")
    public Customer save(final Customer customer) {
        return consumerClient.save(customer);
    }

    /**
     * Hystrix降级.
     *
     * @param id 任意数字
     * @return 无
     */
    @GetMapping("/broken/{id}")
    @HystrixCommand(fallbackMethod = "hystrixDownFallback")
    public Customer hystrixBroker(@PathVariable final Integer id) {

        if (id == 1) {
            throw new RuntimeException("手动报错");
        }
        return consumerClient.findById(id);
    }

    /**
     * 被Hystrix指定的降级方法.
     *
     * @param id 任意数字
     * @return 托底数据
     */
    public Customer hystrixDownFallback(@PathVariable final Integer id) {
        final int age = 23;
        return new Customer(id, "降级信息 [create by provider]", age);
    }

    /**
     * Hystrix缓存测试.
     *
     * @param id 任意数字
     * @return 模拟数据
     */
    @GetMapping("/useCache/{id}")
    public Customer hystrixCache(@RequestParam(value = "id") final Integer id) {

        log.info(customerService.findById(id).toString());
        log.info(customerService.findById(id).toString());
        customerService.clearFindById(id);
        log.info(customerService.findById(id).toString());
        log.info(customerService.findById(id).toString());
        return consumerClient.findById(id);
    }

    /**
     * 测试Zuul的灰度发布.
     *
     * @return 此服务的版本号
     */
    @GetMapping("/version")
    public String version() {

        return version;
    }

    /**
     * 测试feign与hytrix 降级,consumerClient会报错,但provider可以照常显示.
     *
     * @return 1
     */
    @GetMapping("/errors")
    public String error() {
        return consumerClient.simulateError();
    }


}
