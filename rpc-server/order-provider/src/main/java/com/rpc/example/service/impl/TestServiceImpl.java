package com.rpc.example.service.impl;

import com.rpc.example.proxy.RpcRemoteService;
import com.rpc.example.service.ITestService;

/**
 * @author: qiufeng
 * @date: 2020/6/21 16:06
 */
@RpcRemoteService
public class TestServiceImpl implements ITestService {
    @Override
    public String sayHello() {
        return "RETURN SAY_HELLO";
    }
}
