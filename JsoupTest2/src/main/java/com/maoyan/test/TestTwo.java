package com.maoyan.test;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Attribute;
import org.jsoup.nodes.Attributes;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.Set;

/**
 * @author Maoyan
 * @data 2020/3/31 11:30
 * @Version 1.0.0
 */
public class TestTwo {
    public static void main(String[] args) throws IOException {
        Document document = Jsoup.parse(new File("C:\\Users\\HASEE\\Desktop\\index.html"),"utf-8");
//根据id获取元素
        Element element = document.getElementById("test");
//        + 获取id
        String id = element.id();
        System.out.println(id);
//                + 获取className
        String classname = element.className();
        //若class有两个，classNames将会把他们分开
        Set<String> classnames = element.classNames();
        System.out.println(classname);
        for (String s :
                classnames) {
            System.out.println(s);
        }
//                + 获取属性值attr
        //我的文件中有aaaa这个属性，否则空指针异常
        String attr = element.attr("aaaa");
        System.out.println(attr);
//                + 获取所有的属性attributes
        Attributes attributes = element.attributes();
        for (Attribute attrs:attributes) {
            System.out.println(attrs.getValue());
        }
//                + 获取文本内容text
        String text = element.text();
        System.out.println(text);
    }
}
