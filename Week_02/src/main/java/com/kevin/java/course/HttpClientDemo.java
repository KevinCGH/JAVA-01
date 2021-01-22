package com.kevin.java.course;


import org.apache.http.HttpStatus;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author KevinChen
 */
public class HttpClientDemo {
    public static String doGet(String url) {
        String result = null;
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        CloseableHttpResponse response = null;
        try {

            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                result = EntityUtils.toString(response.getEntity(), "UTF-8");
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
