package com.example.hmily.dubbo.system.b;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication(exclude = MongoAutoConfiguration.class)
@ImportResource({"classpath:spring-dubbo.xml"})
@MapperScan("com.example.hmily.dubbo.system.b.mapper")
public class HmilySystemBApplication {

    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication(HmilySystemBApplication.class);
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        springApplication.run(args);
    }

}
