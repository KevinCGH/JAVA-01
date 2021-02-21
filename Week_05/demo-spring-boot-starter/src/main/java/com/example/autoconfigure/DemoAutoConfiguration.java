package com.example.autoconfigure;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;

/**
 * DemoAutoConfiguration
 *
 * @author KevinChen
 * @since 21/2/2021
 */
@Configuration
public class DemoAutoConfiguration {

    @Bean(name = "student100")
    public Student getStudent() {
        Student student = new Student();
        student.setId(1);
        student.setName("周杰伦");
        return student;
    }

    @Bean
    public Klass getKlass() {
        Klass class1 = new Klass();
        class1.setStudents(Arrays.asList(getStudent()));
        return class1;
    }

    @Bean
    public ISchool getSchool() {
        School school = new School();
        school.setClass1(getKlass());
        school.setStudent100(getStudent());
        return school;
    }
}
