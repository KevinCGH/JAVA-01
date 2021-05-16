package com.kevin.java.course.nio02.gateway;

import com.kevin.java.course.nio02.gateway.inbound.HttpInboundServer;

import java.util.Arrays;

/**
 * NettyServerApplication
 *
 * @author KevinChen
 * @since 30/1/2021
 */
public class NettyServerApplication {

    public final static String GATEWAY_NAME = "NIOGateway";
    public final static String GATEWAY_VERSION = "3.0.0";

    public static void main(String[] args) {
        String proxyPort = System.getProperty("proxyPort", "8888");
        String proxyServers = System.getProperty("proxyServers", "http://localhost:8801,http://localhost:8802");
        int port = Integer.parseInt(proxyPort);
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION + " starting...");
        HttpInboundServer server = new HttpInboundServer(port, Arrays.asList(proxyServers.split(",")));
        System.out.println(GATEWAY_NAME + " " + GATEWAY_VERSION + " started at http://localhost:" + port + " for server:" + server.toString());

        try {
            server.run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
