package com.kevin.server.controller;

import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class RequestWrite {

    @NotNull(message = "需要指定 topic")
    private String topic;

    private String content;
}
