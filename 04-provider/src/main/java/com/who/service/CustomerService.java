package com.who.service;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheKey;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheRemove;
import com.netflix.hystrix.contrib.javanica.cache.annotation.CacheResult;
import com.who.client.ConsumerClient;
import com.who.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * 专门为Hystrix的服务缓存新增的Service*
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@Service
public class CustomerService {

    @Resource
    private ConsumerClient searchClient;


    @CacheResult
    @HystrixCommand(commandKey = "findById")
    public Customer findById(@CacheKey Integer id)  {
        return searchClient.findById(id);
    }

    @CacheRemove(commandKey = "findById")
    @HystrixCommand
    public void clearFindById(@CacheKey Integer id){
        System.out.println("findById被清空");
    }

}
