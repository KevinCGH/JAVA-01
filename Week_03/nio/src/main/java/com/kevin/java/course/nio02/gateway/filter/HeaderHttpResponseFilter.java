package com.kevin.java.course.nio02.gateway.filter;

import io.netty.handler.codec.http.FullHttpResponse;

/**
 * HeaderHttpResponseFilter
 *
 * @author KevinChen
 * @since 30/1/2021
 */
public class HeaderHttpResponseFilter implements HttpResponseFilter {
    @Override
    public void filter(FullHttpResponse response) {
        response.headers().set("kk", "java-1-nio");
    }
}
