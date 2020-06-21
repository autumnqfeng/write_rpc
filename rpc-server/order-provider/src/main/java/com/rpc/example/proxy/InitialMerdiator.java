package com.rpc.example.proxy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * 初始化中间代理层对象
 *
 * @author: qiufeng
 * @date: 2020/6/21 16:33
 */
@Component
public class InitialMerdiator implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        //加了服务发布标记的bean进行远程发布
        if (bean.getClass().isAnnotationPresent(RpcRemoteService.class)) {
            Method[] methods = bean.getClass().getDeclaredMethods();
            for (Method method : methods) {
                String routingKey = bean.getClass().getInterfaces()[0].getName() + "." + method.getName();
                BeanMethod beanMethod = new BeanMethod();
                beanMethod.setBean(bean);
                beanMethod.setMethod(method);
                Mediator.ROUTING.put(routingKey, beanMethod);
            }
        }
        return bean;
    }
}
