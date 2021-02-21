package com.example.autoconfigure;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;

/**
 * School
 *
 * @author KevinChen
 * @since 21/2/2021
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class School implements ISchool {

    // Resource
    @Autowired(required = true) // primary
            Klass class1;

    @Resource(name = "student100")
    Student student100;

    @Override
    public void ding() {
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
    }
}
