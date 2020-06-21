package com.rpc.example.proxy;

import java.lang.reflect.Method;

/**
 * 中间层反射调用时，存储目标方法、目标类的实体
 *
 * @author: qiufeng
 * @date: 2020/6/21 16:43
 */
public class BeanMethod {

    private Object bean;

    private Method method;

    public Object getBean() {
        return bean;
    }

    public void setBean(Object bean) {
        this.bean = bean;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }
}
