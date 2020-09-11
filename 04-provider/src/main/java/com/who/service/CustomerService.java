package com.who.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.who.client.ConsumerClient;
import com.who.entity.Customer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 专门为Hystrix的服务缓存新增的Service.
 *
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@Service
public final class CustomerService {

    @Resource
    private ConsumerClient searchClient;


    /**
     * 新增缓存对象.
     *
     * @param id 任意
     * @return customer
     */
    @CacheResult
    @HystrixCommand(commandKey = "findById")
    public Customer findById(@CacheKey final Integer id) {
        return searchClient.findById(id);
    }

    /**
     * 清空缓存.
     *
     * @param id
     */
    @CacheRemove(commandKey = "findById")
    @HystrixCommand
    public void clearFindById(@CacheKey final Integer id) {
        System.out.println("findById被清空");
    }

}
