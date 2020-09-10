package com.who.controller;

import com.who.client.OtherServiceClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * 第三方服务
 * @author 胡昊宁
 * @date 2020/9/9 23:01
 */
@RestController
public class OtherServiceController {
    @Resource
    private OtherServiceClient otherServiceClient;

    @Value("${server.port}")
    private String port;
    /**
     * 使用zool后,可以通过http://localhost/other-service/list访问
     * @return 端口号
     */
    @GetMapping("/list")
    public String list(){
        return otherServiceClient.list()+"  port:"+port;
    }
}
