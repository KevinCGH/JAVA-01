package io.kimmking.spring01;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

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
public class Student implements Serializable, BeanNameAware, ApplicationContextAware {
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
