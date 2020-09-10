package com.who.client.fallback;

import com.who.client.ConsumerClient;
import com.who.entity.Customer;
import org.springframework.stereotype.Component;


/**
 * feign和hystrix实现熔断降级,把这个指定给SearchClient的FeignClient注释的fallback属性
 * @author 胡昊宁
 * @date 2020/9/10 8:42
 */
@Component
public class ConsumerClientFallBack implements ConsumerClient {

    @Override
    public String consumer() {
        return null;
    }

    @Override
    public String port() {
        return null;
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public Customer getCustomer(Integer id, String name) {
        return null;
    }

    @Override
    public Customer save(Customer customer) {
        return null;
    }

    @Override
    public String simulateError() {
        return "出错了";
    }
}
