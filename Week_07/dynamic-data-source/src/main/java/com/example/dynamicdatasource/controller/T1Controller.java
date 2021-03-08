package com.example.dynamicdatasource.controller;

import com.example.dynamicdatasource.model.T1;
import com.example.dynamicdatasource.service.T1Service;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * T1Controller
 *
 * @author KevinChen
 * @since 8/3/2021
 */
@RestController
@AllArgsConstructor
@RequestMapping("/t1")
public class T1Controller {
    private final T1Service service;

    @GetMapping("/{id}")
    public T1 getT1(@PathVariable("id") Long id) {
        return service.select(id);
    }

    @GetMapping()
    public List<T1> selectAll() {
        return service.selectAll();
    }

    @PostMapping
    public boolean addT1(@RequestBody T1 t1) {
        return service.add(t1);
    }
}
