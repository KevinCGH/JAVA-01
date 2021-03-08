package com.example.dynamicdatasource.mapper;

import com.example.dynamicdatasource.model.T1;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * T1Mapper
 *
 * @author KevinChen
 * @since 8/3/2021
 */
@Mapper
public interface T1Mapper {

    T1 select(@Param("id") long id);

    List<T1> selectAll();

    Integer insert(T1 t);
}
