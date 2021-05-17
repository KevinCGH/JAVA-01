package com.kevin.server.core;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;
import java.util.HashMap;

@Data
@AllArgsConstructor
public class KmqMessage<T> implements Serializable {

    private static final long serialVersionUID = 1435515995276255188L;

    private HashMap<String, Object> headers;

    private T body;
}
