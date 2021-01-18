package com.kevin.java.course.nio01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import static com.kevin.java.course.nio01.HttpUtil.service;

/**
 * 单线程http服务器 8801
 *
 * @author workstem
 */
public class HttpServer01 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8801);
        while (true) {
            Socket socket = serverSocket.accept();
            service(socket);
        }
    }
}
