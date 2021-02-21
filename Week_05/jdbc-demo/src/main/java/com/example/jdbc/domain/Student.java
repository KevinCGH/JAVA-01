package com.example.jdbc.domain;

import lombok.Data;
import lombok.ToString;

/**
 * Student
 *
 * @author KevinChen
 * @since 21/2/2021
 */
@Data
@ToString
public class Student {
    private long id;
    private String name;
    private int age;
}
