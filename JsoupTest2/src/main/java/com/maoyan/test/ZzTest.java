package com.maoyan.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author Maoyan
 * @data 2020/3/31 19:39
 * @Version 1.0.0
 */
public class ZzTest {
    private static Pattern pattern = Pattern.compile("/images/\\w+");
    private static Pattern pattern2 = Pattern.compile("images");
    public static void main(String[] args) {
        String sec = "第1页：https://gank.iobackground-image:url('/images/0fdac44dada5489b85049a3f3fb7fd85')";
        Matcher matcher = pattern.matcher(sec);
        while (matcher.find()) {
            System.out.println(matcher.group());
        }
    }
}
