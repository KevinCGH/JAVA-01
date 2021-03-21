package com.example.hmily.dubbo.system.a;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource({"classpath:spring-dubbo.xml"})
@MapperScan("com.example.hmily.dubbo.system.a.mapper")
public class HmilySystemAApplication {
    public static void main(String[] args) {
        SpringApplication.run(HmilySystemAApplication.class, args);
    }
}
