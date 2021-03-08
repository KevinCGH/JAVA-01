package com.example.dynamicdatasource;

import com.example.dynamicdatasource.model.T1;
import com.example.dynamicdatasource.service.T1Service;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

@SpringBootTest
class DynamicDataSourceApplicationTests {

    @Autowired
    private T1Service service;

    @Test
    void contextLoads() {
        long length = service.selectAll().stream().count();
        long id = length + 1;
        boolean res = service.add(new T1(id));
        Assert.isTrue(res, "Insert data failed.");
        T1 inserted = service.select(id);
        Assert.notNull(inserted, "Select T1 by id " + id + " failed.");
    }

}
