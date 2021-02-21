package io.kimmking.spring02;

import io.kimmking.spring01.Student;
import lombok.Data;

import java.util.List;

/**
 * Klass
 *
 * @author KevinChen
 * @since 20/2/2021
 */
@Data
public class Klass {
    List<Student> students;

    public void dong() {
        System.out.println(this.getStudents());
    }
}
