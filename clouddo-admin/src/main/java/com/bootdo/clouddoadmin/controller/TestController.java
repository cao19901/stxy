package com.bootdo.clouddoadmin.controller;

import com.bootdo.clouddoadmin.rpc.TestRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping
public class TestController {
    @Autowired
    TestRpc testRpc;

    @Autowired

    private RestTemplate restTemplate ;

    @GetMapping("test")
    String test() {
        return testRpc.test();
    }
    @GetMapping("test1")
    Object test1() {
        /**
         https://blog.csdn.net/a1032818891/article/details/81172478
         */

        return restTemplate.exchange("https://www.baidu.com" ,HttpMethod.GET , null ,String.class);
    }
}
