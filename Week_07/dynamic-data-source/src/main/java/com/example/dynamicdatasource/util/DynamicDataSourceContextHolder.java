package com.example.dynamicdatasource.util;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * DynamicDataSourceContextHolder
 *
 * @author KevinChen
 * @since 8/3/2021
 */
@Slf4j
public class DynamicDataSourceContextHolder {
    private static final ThreadLocal<String> CONTEXT_HOLDER = ThreadLocal.withInitial(DataSourceKey.master::name);

    public static List<Object> dataSourceKey = new ArrayList<>();

    public static List<Object> slaveDataSourceKeys = new ArrayList<>();
    private static int counter = 0;

    public static void setDataSourceKey(String key) {
        CONTEXT_HOLDER.set(key);
    }

    public static String getDataSourceKey() {
        return CONTEXT_HOLDER.get();
    }

    public static void clearDataSourceKey() {
        CONTEXT_HOLDER.remove();
    }

    public static boolean containDataSourceKey(String key) {
        return dataSourceKey.contains(key);
    }

    public static void useSlaveDataSource() {
        try {
            int dataSourceKeyIndex = counter % slaveDataSourceKeys.size();
            CONTEXT_HOLDER.set(String.valueOf(slaveDataSourceKeys.get(dataSourceKeyIndex)));
            counter++;
        } catch (Exception e) {
            log.error("Switch slave datasource failed. error message is {}", e.getMessage());
            useMasterDataSource();
            e.printStackTrace();
        }
    }

    private static void useMasterDataSource() {
        CONTEXT_HOLDER.set(DataSourceKey.master.name());
    }
}
