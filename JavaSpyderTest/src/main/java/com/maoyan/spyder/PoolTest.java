package com.maoyan.spyder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Maoyan
 * @data 2020/3/30 14:13
 * @Version 1.0.0
 */
public class PoolTest {
    public static void main(String[] args) throws URISyntaxException {
        //创建连接池管理器
        PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager();
        //设置最大连接数
        connectionManager.setMaxTotal(100);
        //设置每个主机的最大连接数
        connectionManager.setDefaultMaxPerRoute(10);
        //使用连接池发起请求
        doGet(connectionManager);
        doGet(connectionManager);
    }

    private static void doGet(PoolingHttpClientConnectionManager connectionManager) throws URISyntaxException {
        //不是创建httpclient对象，而是从连接池获取
        CloseableHttpClient httpClient = HttpClients.custom().setConnectionManager(connectionManager).build();
        //下面的就是正常的请求
        CloseableHttpResponse response = null;
        //创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search");
        //设置参数
        uriBuilder.setParameter("keys","java");
        //输入网址，发起Get请求，创建HttpGet对象
        HttpGet httpGet = new HttpGet(uriBuilder    .build());

        try {
            //发起请求，返回响应
            response = httpClient.execute(httpGet);
            //解析数据，获取数据
            //判断状态码
            if (response.getStatusLine().getStatusCode()==200){
                HttpEntity entity = response.getEntity();
                String content = EntityUtils.toString(entity,"utf-8");
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("发起请求失败");
        }finally {
            //释放资源
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
          //httpclient不能直接close
            //应该由连接池管理器来管理
        }
    }
}
