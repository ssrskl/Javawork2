package com.maoyan.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Maoyan
 * @data 2020/3/31 11:44
 * @Version 1.0.0
 */
public class SelectorTest {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.parse(new File("C:\\Users\\HASEE\\Desktop\\index.html"),"utf-8");
//        - tagname：通过标签查找
        Elements elements1 = document.select("span");
        for (Element e:elements1) {
            System.out.println("通过标签："+e.text());
        }

//                - #id：通过id查找
        Elements elements2 = document.select("#test");
        for (Element e:elements2) {
            System.out.println("通过id："+e.text());
        }

//                - .class：通过class查找
        Element element = document.select(".class_a").first();
        System.out.println("通过class"+element.text());

//                - [attribute]：通过属性查找
        Element element1 = document.select("[aaaa]").first();
        System.out.println("通过属性"+element1.text());

//                - [attr=value]：通过属性值
        Element element2 = document.select("[aaaa=112233]").first();
        System.out.println("通过属性值"+element2.text());
    }
}
