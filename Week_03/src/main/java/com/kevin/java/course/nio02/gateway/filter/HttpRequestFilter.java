package com.kevin.java.course.nio02.gateway.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

/**
 * HttpRequestFilter
 *
 * @author KevinChen
 * @since 30/1/2021
 */
public interface HttpRequestFilter {
    void filter(FullHttpRequest fullHttpRequest, ChannelHandlerContext ctx);
}
