package com.who.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试接入第三方服务.
 *
 * @author MR.HU
 */
@FeignClient("OTHER-SERVICE")
public interface OtherServiceClient {

    /**
     * 测试接入第三方服务.
     *
     * @return list
     */
    @RequestMapping("/otherService")
    String list();

}
