package com.kevin.java.course.nio01;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * service 公共类
 *
 * @author workstem
 */
public class HttpUtil {
    public static void service(Socket socket) {
        try {
//            Thread.sleep(20);
            PrintWriter printWriter = new PrintWriter(socket.getOutputStream(), true);
            printWriter.println("HTTP/1.1 200 OK");
            printWriter.println("Content-Type:text/html;charset=utf-8");
            String body = "hello,nio";
            printWriter.println("Content-Length:" + body.getBytes().length);
            printWriter.println();
            printWriter.write(body);
            printWriter.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
