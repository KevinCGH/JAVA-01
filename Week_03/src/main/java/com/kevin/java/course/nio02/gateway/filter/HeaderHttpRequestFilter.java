package com.kevin.java.course.nio02.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * HeaderHttpRequestFilter
 *
 * @author KevinChen
 * @since 30/1/2021
 */
public class HeaderHttpRequestFilter implements HttpRequestFilter {
    @Override
    public void filter(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx) {
        fullHttpRequest.headers().set("mao", "soul");
    }
}
