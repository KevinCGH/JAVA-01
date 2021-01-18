package com.kevin.java.course.nio01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.kevin.java.course.nio01.HttpUtil.service;

/**
 * 多线程http服务器 8802
 *
 * @author workstem
 */
public class HttpServer02 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8802);
        while (true) {
            Socket socket = serverSocket.accept();
            new Thread(() -> {
                service(socket);
            }).start();
        }
    }
}
