package com.rpc.example.socket;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * spring 容器启动完成之后，会发布一个ContextRefreshedEven
 * 容器启动后启动socket监听
 *
 * @author: qiufeng
 * @date: 2020/6/21 16:51
 */
@Component
public class SocketServer implements ApplicationListener<ContextRefreshedEvent> {
    private final ExecutorService executorService= Executors.newCachedThreadPool();

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        ServerSocket serverSocket=null;
        try {
            serverSocket = new ServerSocket(8888);
            while (true) {
                Socket accept = serverSocket.accept();
                executorService.execute(new ProcessorHandler(accept));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                try {
                    serverSocket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
