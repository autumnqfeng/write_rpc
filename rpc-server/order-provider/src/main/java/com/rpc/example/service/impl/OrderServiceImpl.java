package com.rpc.example.service.impl;

import com.rpc.example.proxy.RpcRemoteService;
import com.rpc.example.service.IOrderService;

/**
 * @author: qiufeng
 * @date: 2020/6/21 16:04
 */
@RpcRemoteService
public class OrderServiceImpl implements IOrderService {
    @Override
    public String queryOrderList() {
        return "EXECUTE QUERY_ORDER_LIST METHOD";
    }

    @Override
    public String orderById(String id) {
        return "EXECUTE ORDER_BY_ID METHOD";
    }
}
