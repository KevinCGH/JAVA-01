package com.kevin.java.course.nio01;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static com.kevin.java.course.nio01.HttpUtil.service;

/**
 * 多线程（线程池）http服务器 8803
 *
 * @author workstem
 */
public class HttpServer03 {
    private static int port = 8803;

    public static void main(String[] args) throws IOException {
        ExecutorService executorService = Executors.newFixedThreadPool(40);
        final ServerSocket serverSocket = new ServerSocket(port);
        System.out.println("Listening to port: " + port);
        while (true) {
            final Socket socket = serverSocket.accept();
            System.out.println("server connect");
            executorService.execute(() -> service(socket));
        }
    }
}
