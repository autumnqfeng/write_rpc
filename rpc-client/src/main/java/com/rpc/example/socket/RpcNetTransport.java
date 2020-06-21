package com.rpc.example.socket;

import com.rpc.example.RpcRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/**
 * rpc socket 网络传输
 *
 * @author: qiufeng
 * @date: 2020/6/20 22:59
 */
@Component
public class RpcNetTransport {
    @Value("${rpc.host}")
    private String host;
    @Value("${rpc.port}")
    private int port;


    public Object send(RpcRequest rpcRequest) {
        ObjectOutputStream outputStream = null;
        ObjectInputStream inputStream = null;
        try {
            Socket socket = new Socket(host, port);
            outputStream = new ObjectOutputStream(socket.getOutputStream());
            outputStream.writeObject(rpcRequest);
            outputStream.flush();

            inputStream = new ObjectInputStream(socket.getInputStream());
            return inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(inputStream, outputStream);
        }
        return null;
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
