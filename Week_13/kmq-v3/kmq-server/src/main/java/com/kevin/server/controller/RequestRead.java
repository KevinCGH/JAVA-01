package com.kevin.server.controller;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class RequestRead {

    @NotNull(message = "需要指定 topic")
    private String topic;

    @Min(value = 0, message = "offset 必须大于等于0")
    private Integer offset = 0;
}
