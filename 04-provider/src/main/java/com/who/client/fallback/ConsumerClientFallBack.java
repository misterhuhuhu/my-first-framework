package com.who.client.fallback;

import com.who.client.ConsumerClient;
import com.who.entity.Customer;
import org.springframework.stereotype.Component;


/**
 * feign和hystrix实现熔断降级,把这个指定给SearchClient的FeignClient注释的fallback属性.
 *
 * @author 胡昊宁
 * @date 2020/9/10 8:42
 */
@Component
public class ConsumerClientFallBack implements ConsumerClient {

    /**
     * 无降级方法.
     *
     * @return 无
     */
    @Override
    public String consumer() {
        return null;
    }

    /**
     * 无降级方法.
     *
     * @return 无
     */
    @Override
    public String port() {
        return null;
    }

    /**
     * 无降级方法.
     *
     * @return 无
     */
    @Override
    public Customer findById(final Integer id) {
        return null;
    }

    /**
     * 无降级方法.
     *
     * @return 无
     */
    @Override
    public Customer getCustomer(final Integer id, final String name) {
        return null;
    }

    /**
     * 无降级方法.
     *
     * @return 无
     */
    @Override
    public Customer save(final Customer customer) {
        return null;
    }

    /**
     * 模拟降级方法.
     *
     * @return 出错了
     */
    @Override
    public String simulateError() {
        return "出错了";
    }
}
