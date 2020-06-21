package com.rpc.example.socket;

import com.rpc.example.RpcRequest;
import com.rpc.example.proxy.Mediator;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * @author: qiufeng
 * @date: 2020/6/21 17:08
 */
public class ProcessorHandler implements Runnable {

    private Socket socket;

    public ProcessorHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        ObjectInputStream inputStream = null;
        ObjectOutputStream outputStream = null;
        try {
            inputStream = new ObjectInputStream(socket.getInputStream());
            // 反序列化
            RpcRequest rpcRequest = (RpcRequest) inputStream.readObject();

            // 中间代理执行目标方法
            Mediator mediator = Mediator.getInstance();
            Object response = mediator.processor(rpcRequest);
            System.out.println("服务端的执行结果："+response);

            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(response);
            outputStream.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            closeStream(inputStream, outputStream);
        }
    }

    private void closeStream(ObjectInputStream inputStream, ObjectOutputStream outputStream) {
        // 关闭流
        if(inputStream!=null){
            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        if (outputStream!=null){
            try {
                outputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
