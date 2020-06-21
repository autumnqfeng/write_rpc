package com.rpc.example;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: qiufeng
 * @date: 2020/6/21 12:41
 */
@Configuration
@ComponentScan("com.rpc.example")
public class Bootstrap {
    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(Bootstrap.class);
    }
}
