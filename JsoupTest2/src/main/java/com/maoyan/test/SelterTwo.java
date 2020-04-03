package com.maoyan.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author Maoyan
 * @data 2020/3/31 11:57
 * @Version 1.0.0
 */
public class SelterTwo {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.parse(new File("C:\\Users\\HASEE\\Desktop\\index.html"),"utf-8");

//        + el#id：元素+id
        Element element = document.select("li#test").first();
        System.out.println(element.text());

//                + el.class：元素+class
        Element element1 = document.select("li.class_a").first();
        System.out.println(element1.text());

//        + el[attr]：元素+属性名
        Element element2 = document.select("span[abc]").first();
        System.out.println(element2.text());

//                + 任意组合
        Element element3 = document.select("span[abc].123").first();
        System.out.println(element3.text());

//                + ancestor child：查找某元素的ziyuansu
        Element element4 = document.select(".city_all li").first();
        System.out.println(element4.text());

//                + parent>child：查找某个父元素下的直接子元素
        Element element5 = document.select(".city_all>ul>li").first();
        System.out.println(element5.text());

//                + parent>*查找某个父元素下的所有直接子元素
        Elements elements = document.select(".city_all>ul>*");
        for (Element e:elements) {
            System.out.println(e.text());
        }
    }
}
