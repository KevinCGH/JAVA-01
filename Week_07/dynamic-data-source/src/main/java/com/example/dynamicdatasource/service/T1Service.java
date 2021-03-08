package com.example.dynamicdatasource.service;

import com.example.dynamicdatasource.mapper.T1Mapper;
import com.example.dynamicdatasource.model.T1;
import lombok.AllArgsConstructor;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * T1Service
 *
 * @author KevinChen
 * @since 8/3/2021
 */
@Service
@AllArgsConstructor
public class T1Service {
    private final T1Mapper t1Mapper;

    public T1 select(long id) {
        T1 t1 = t1Mapper.select(id);
        if (t1 == null) {
            throw new RuntimeException("Record:" + id + " not found");
        }
        return t1;
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public boolean add() {
        return add(new T1());
    }

    @Transactional(rollbackFor = DataAccessException.class)
    public boolean add(T1 t1) {
        Integer res = t1Mapper.insert(t1);
        if (res <= 0) {
            throw new RuntimeException("Add T1 failed");
        }
        return true;
    }

    public List<T1> selectAll() {
        return t1Mapper.selectAll();
    }
}
