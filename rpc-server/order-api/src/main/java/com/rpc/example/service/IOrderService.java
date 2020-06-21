package com.rpc.example.service;

/**
 * @author: qiufeng
 * @date: 2020/6/20 15:59
 */
public interface IOrderService {

    String queryOrderList();

    String orderById(String id);
}
