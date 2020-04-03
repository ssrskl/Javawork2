package com.maoyan.spyder;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Maoyan
 * @data 2020/3/30 14:01
 * @Version 1.0.0
 */
public class PostParamTest {
    public static void main(String[] args) throws UnsupportedEncodingException {
        //创建httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建post对象
        HttpPost post = new HttpPost("http://yun.itheima.com/search");
        //声明List集合，封装表单中的参数
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        //设置请求地址
        params.add(new BasicNameValuePair("keys","Java"));
        //创建表单中的Entity对象
        UrlEncodedFormEntity encodedFormEntity = new UrlEncodedFormEntity(params,"utf-8");
        //设置Enitity到post中
        post.setEntity(encodedFormEntity);
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
