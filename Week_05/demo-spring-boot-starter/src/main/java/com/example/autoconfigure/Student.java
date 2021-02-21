package com.example.autoconfigure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.context.ApplicationContext;

import java.io.Serializable;

/**
 * Student
 *
 * @author KevinChen
 * @since 20/2/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student implements Serializable {
    private int id;
    private String name;

    private String beanName;
    @ToString.Exclude
    private ApplicationContext applicationContext;

    public void init() {
        System.out.println("hello...........");
    }

    public void print() {
        System.out.println(this.beanName);
        System.out.println("   context.getBeanDefinitionNames() ===>> "
                + String.join(",", applicationContext.getBeanDefinitionNames()));
    }


}
