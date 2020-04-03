package com.maoyan.spyder;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URISyntaxException;

/**
 * @author Maoyan
 * @data 2020/3/30 14:30
 * @Version 1.0.0
 */
public class ConfigTest {
    public static void main(String[] args) throws URISyntaxException, IOException {

        CloseableHttpResponse response = null;
        //打开浏览器，创建HttpClient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建URIBuilder
        URIBuilder uriBuilder = new URIBuilder("http://yun.itheima.com/search");
        //设置参数
        uriBuilder.setParameter("keys","java");
        //输入网址，发起Get请求，创建HttpGet对象
        HttpGet httpGet = new HttpGet(uriBuilder.build());

        //配置请求信息
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000)//创建连接的最长时间
                .setConnectionRequestTimeout(500)//获取连接的最长时间
                .setSocketTimeout(10*1000)//数据传输的最长时间
                .build();

        //给请求设置请求信息
        httpGet.setConfig(config);
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
            response.close();
            httpClient.close();
        }
    }
}
