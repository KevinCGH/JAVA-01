package com.example.jdbc;

import com.example.jdbc.demo.Demo;
import com.example.jdbc.repository.StudentJdbcRepository;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Iterator;
import java.util.Set;

@Slf4j
@SpringBootApplication
public class JdbcDemoApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JdbcDemoApplication.class, args);
    }

    @Autowired
    StudentJdbcRepository repository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Reflections reflections = new Reflections("com.example.jdbc.demo");
        Set<Class<? extends Demo>> experiments = reflections.getSubTypesOf(Demo.class);
        Iterator<Class<? extends Demo>> iterator = experiments.iterator();
        while (iterator.hasNext()) {
            Class<? extends Demo> clz = iterator.next();
            log.info("<<======= {} =======>>", clz.getName());
            Demo instance = clz.newInstance();
            instance.run();
        }
    }
}
