package com.maoyan.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Maoyan
 * @data 2020/3/30 21:01
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) throws IOException {
        //解析url地址，第一个参数是url，第二个参数是访问超时时间
        Document document = Jsoup.parse(new URL("https://www.baidu.com"),1000);
        //使用标签选择器
        String content = document.getElementsByTag("title").first().text();
        System.out.println(content);

        //直接解析字符串
        String conten2 = "<title>JsoupTest</title>";
        Document document1 = Jsoup.parse(conten2);
        conten2 = document1.getElementsByTag("title").first().text();
        System.out.println(conten2);

        //解析文件
        //System.out.println(System.getProperty("user.dir"));
        Document document2 = Jsoup.parse(new File(System.getProperty("user.dir")+"\\src"+"\\Test.html"),"utf-8");
        String content3 = document2.getElementsByTag("title").first().text();
        System.out.println(content3);

        //Dom遍历文档
        Document document3 = Jsoup.parse(new File("C:\\Users\\HASEE\\Desktop\\index.html"),"utf-8");
        //根据id查询元素
        Element element = document3.getElementById("test");
        System.out.println("根据id: "+element.text());

        //根据标签
        Elements element1 = document3.getElementsByTag("span");
        for (Element e :
                element1) {
            System.out.println("根据标签："+e.text());
        }

        //根据class
        Elements element3 = document3.getElementsByClass("class_a");
        System.out.println(element3.first().text());

        //根据属性获取元素
        Elements element2 = document3.getElementsByAttribute("abc");
        System.out.println(element2.first().text());
    }
}
