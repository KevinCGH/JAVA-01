package com.example.jdbc.repository;

import com.example.jdbc.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * StudentJdbcRepository
 *
 * @author KevinChen
 * @since 21/2/2021
 */
@Repository
public class StudentJdbcRepository {
    @Autowired
    JdbcTemplate jdbcTemplate;

    public Student findById(long id) {
        return jdbcTemplate.queryForObject("SELECT * FROM student WHERE id=?",
                new BeanPropertyRowMapper<Student>(Student.class), new Object[]{id});
    }
}
