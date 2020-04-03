package com.maoyan.spyder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

/**
 * @author Maoyan
 * @data 2020/3/30 13:49
 * @Version 1.0.0
 */
public class PostTest {
    public static void main(String[] args) {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post对象
        HttpPost post = new HttpPost("http://catjava.top");
        //创建响应对象
        //发起请求
        CloseableHttpResponse response = null;
        try {
            response = httpClient.execute(post);
            //判断状态码
            if (response.getStatusLine().getStatusCode()==200){
                //解析数据
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity,"utf-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
