package com.example.statertest;

import com.example.autoconfigure.ISchool;
import com.example.autoconfigure.Klass;
import com.example.autoconfigure.School;
import com.example.autoconfigure.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StaterTestApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(StaterTestApplication.class, args);
    }

    @Autowired
    private Klass class1;
    @Autowired
    private Student student;
    @Autowired
    private ISchool school;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(class1);
        System.out.println(student);
        System.out.println(school);
    }
}
