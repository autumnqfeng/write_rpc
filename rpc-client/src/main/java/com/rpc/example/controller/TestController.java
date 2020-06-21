package com.rpc.example.controller;

import com.rpc.example.ploxy.RpcReference;
import com.rpc.example.service.IOrderService;
import com.rpc.example.service.ITestService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: qiufeng
 * @date: 2020/6/20 22:29
 */
@RestController
public class TestController {

    @RpcReference
    private IOrderService orderService;

    @RpcReference
    private ITestService testService;

    @GetMapping("/test")
    public String test(){
        return orderService.queryOrderList();
    }

    @GetMapping("/get")
    public String get(){
        return testService.sayHello();
    }
}
