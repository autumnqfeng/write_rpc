package com.rpc.example;

import java.io.Serializable;

/**
 * rpc通信参数传递类
 *
 * @author: qiufeng
 * @date: 2020/6/21 16:00
 */
public class RpcRequest implements Serializable {
    private static final long serialVersionUID = 5602161762057659482L;

    /** 类名 */
    private String className;
    /** 方法名 */
    private String methodName;
    /** 参数 */
    private Object[] args;
    /** 参数类型 */
    private Class[] types;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }

    public Class[] getTypes() {
        return types;
    }

    public void setTypes(Class[] types) {
        this.types = types;
    }
}
