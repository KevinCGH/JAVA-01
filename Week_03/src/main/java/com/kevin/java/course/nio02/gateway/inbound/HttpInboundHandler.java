package com.kevin.java.course.nio02.gateway.inbound;

import com.kevin.java.course.nio02.gateway.filter.HeaderHttpRequestFilter;
import com.kevin.java.course.nio02.gateway.filter.HttpRequestFilter;
import com.kevin.java.course.nio02.gateway.outbound.httpclient4.HttpOutboundHandler;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.codec.http.FullHttpRequest;
import io.netty.util.ReferenceCountUtil;
import io.netty.util.concurrent.EventExecutorGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * HttpInboundHandler
 *
 * @author KevinChen
 * @since 30/1/2021
 */
public class HttpInboundHandler extends ChannelInboundHandlerAdapter {

    private static Logger logger = LoggerFactory.getLogger(HttpInboundHandler.class);
    private final List<String> proxyServers;
    private HttpOutboundHandler handler;
    private HttpRequestFilter filter = new HeaderHttpRequestFilter();


    public HttpInboundHandler(List<String> proxyServers) {
        this.proxyServers = proxyServers;
        this.handler = new HttpOutboundHandler(this.proxyServers);
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.flush();
    }

    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        try {
            long startTime = System.currentTimeMillis();
            logger.info("channelRead 流量接口请求开始，时间为{}", startTime);
            FullHttpRequest fullHttpRequest = (FullHttpRequest) msg;
            String uri = fullHttpRequest.uri();
            logger.info("接收到的请求url为{}", uri);
            handler.handle(fullHttpRequest, ctx, filter);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ReferenceCountUtil.release(msg);
        }
    }
}
