package com.rpc.example.ploxy;

import com.rpc.example.RpcRequest;
import com.rpc.example.socket.RpcNetTransport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author: qiufeng
 * @date: 2020/6/20 22:51
 */
@Component
public class RemoteInvocationHandler implements InvocationHandler {

    @Autowired
    private RpcNetTransport rpcNetTransport;

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        RpcRequest rpcRequest = new RpcRequest();
        rpcRequest.setClassName(method.getDeclaringClass().getName());
        rpcRequest.setMethodName(method.getName());
        rpcRequest.setTypes(method.getParameterTypes());
        rpcRequest.setArgs(args);
        return rpcNetTransport.send(rpcRequest);
    }
}
