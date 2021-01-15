package com.kevin.java.course.jvm;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

/**
 * 自定义类加载器
 *
 * @author KevinChen
 * @since 2021-01-15
 */
public class HelloClassLoader extends ClassLoader {
    public static void main(String[] args) {
        try {
            Class<?> clazz = new HelloClassLoader().findClass("Hello");
            clazz.getMethod("hello").invoke(clazz.newInstance());
        } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        try (InputStream in = getClass().getResourceAsStream(name + ".xlass")) {
            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);
            byte[] temp = new byte[1024];
            int size;
            while ((size = in.read(temp)) != -1) {
                bos.write(temp, 0, size);
            }
            byte[] content = bos.toByteArray();
            return defineClass(name, decode(content), 0, content.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return super.findClass(name);
    }

    private byte[] decode(byte[] sources) {
        for (int i = 0; i < sources.length; i++) {
            sources[i] = (byte) (255 - sources[i]);
        }
        return sources;
    }
}
