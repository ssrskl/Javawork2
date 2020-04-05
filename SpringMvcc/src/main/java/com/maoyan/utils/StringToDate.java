package com.maoyan.utils;

import org.springframework.core.convert.converter.Converter;

import javax.swing.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Maoyan
 * @data 2020/4/3 14:40
 * @Version 1.0.0
 */
//自定义的类型转换器
public class StringToDate implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        //判断是否为空
        if (source == null){
            throw new RuntimeException("请填写数据");
        }else {
            DateFormat dateFormat = new SimpleDateFormat("YYYY-MM-DD");//设定日期的格式
            try {
                return dateFormat.parse(source);
            } catch (ParseException e) {
                throw new RuntimeException("转换出现异常");
            }
        }
    }
}
