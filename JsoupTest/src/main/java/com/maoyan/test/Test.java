package com.maoyan.test;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Maoyan
 * @data 2020/3/30 18:57
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //解析url，第一个参数是url，第二个是访问的超时时间
        Document document = Jsoup.parse(new URL("https://www.baidu.com"),1000);
        //使用标签选择器，获取标签的内容
        String content = document.getElementsByTag("title").first().text();
        System.out.println(content);
    }
}
