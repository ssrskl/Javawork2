package com.maoyan;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.xml.ws.spi.http.HttpContext;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * @author Maoyan
 * @data 2020/3/31 10:49
 * @Version 1.0.0
 */
public class Sprder {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://gank.io/special/Girl/page/1");
        Document document = Jsoup.parse(url,100*1000);
        System.out.println(document);
        Elements elements = document.getElementsByTag("title");
        for (Element e:elements) {
            System.out.println(e.text());
        }
    }
}
