package com.kevin.java.course;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;

/**
 * @author KevinChen
 */
public class OkHttpDemo {
    public static String doGet(String url) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().get().url(url).build();
        String result = null;
        try {
            Response response = client.newCall(request).execute();
            if (response.isSuccessful()) {
                result = response.body().string();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            return result;
        }
    }

    public static void main(String[] args) {
        String url = "http://localhost:8801";
        System.out.println("request: " + url);
        String res = doGet(url);
        System.out.println("response: [Content=" + res + ", Content-Length=" + res.length() + "]");
    }
}
