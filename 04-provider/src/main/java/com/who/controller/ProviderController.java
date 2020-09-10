package com.who.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.who.client.ConsumerClient;
import com.who.entity.Customer;
import com.who.service.CustomerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

/**
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@RestController
public class ProviderController {
    @Resource
    private RestTemplate restTemplate;

    /**
     * 测试robbin均衡负载
     * @return  consumer的端口号
     */
    @GetMapping("/robbin")
    public String port() {
        return restTemplate.getForObject("http://consumer/port", String.class);
    }
    @Resource
    private ConsumerClient consumerClient;

    /**
     * 测试robbin传参 测试//http://localhost:9500/search/1
     * @param id    任意数字
     * @return  返回模拟的customer
     */
    @GetMapping("/search/{id}")
    public Customer findById(@PathVariable Integer id) {
        return consumerClient.findById(id);
    }

    /**
     * 测试feign传两个参数 测试//http://localhost:9500/getCustomer?id=1&name=xxx
     * @param id 任意数字
     * @param name  非符号字符串
     * @return  返回模拟的customer
     */
    @GetMapping("/getCustomer")
    public Customer getCustomer(@RequestParam Integer id, @RequestParam String name) {
        return consumerClient.getCustomer(id,name);
    }

    /**
     * Feign再传递复杂参数时自动转换为POST
     * @param customer  模拟使用post传值的customer
     * @return  输入的customer
     */
    @GetMapping("/save")
    public Customer save( Customer customer) {
        return consumerClient.save(customer);
    }

    /**
     * Hystrix降级
     * @param id 任意数字
     * @return 无
     */
    @GetMapping("/broken/{id}")
    @HystrixCommand(fallbackMethod = "hystrixDownFallback")
    public Customer hystrixBroker(@PathVariable Integer id) {

        if(id == 1){
            throw new RuntimeException("手动报错");
        }
        return consumerClient.findById(id);
    }

    /**
     * 被Hystrix指定的降级方法
     * @param id 任意数字
     * @return 托底数据
     */
    public Customer hystrixDownFallback(@PathVariable Integer id) {
        return new Customer(id,"降级信息 [create by provider]",23);
    }


    @Resource
    private CustomerService customerService;
    /**
     * Hystrix降级
     * @param id    任意数字
     * @return  模拟数据
     */
    @GetMapping("/useCache/{id}")
    public Customer hystrixCache(@RequestParam(value = "id") Integer id) {

        System.out.println(customerService.findById(id));
        System.out.println(customerService.findById(id));
        customerService.clearFindById(id);
        System.out.println(customerService.findById(id));
        System.out.println(customerService.findById(id));
        return consumerClient.findById(id);
    }


    @Value("${version}")
    private String version;

    /**
     * 测试Zuul的灰度发布
     * @return  此服务的版本号
     */
    @GetMapping("/version")
    public String version() {

        return version;
    }

    /**
     * 测试feign与hytrix 降级,consumerClient会报错,但provider可以照常显示
     * @return  1
     */
    @GetMapping("/errors")
    public String error() {
        return consumerClient.simulateError();
    }


}
