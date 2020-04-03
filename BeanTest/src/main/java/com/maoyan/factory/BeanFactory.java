package com.maoyan.factory;

import com.sun.xml.internal.bind.v2.model.core.EnumConstant;

import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * @author Maoyan
 * @data 2020/3/27 16:26
 * @Version 1.0.0
 */
public class BeanFactory {

    //定义一个Properties对象
    private static Properties properties;
    //单例：定义一个Map储存创建的对象
    private static Map<String,Object> beans;

    //使用静态代码块为Properties对象赋值
    static {
        //实例化对象
        properties = new Properties();
        //获取流:通过类加载器
        InputStream inputStream = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            properties.load(inputStream);

            //实例化容器
            beans = new HashMap<String, Object>();
            //取出配置文件中所有的key
            Enumeration keys = properties.keys();
            //遍历枚举
            while (keys.hasMoreElements()){
                String key = keys.nextElement().toString();
                //根据key获取value
                String beanPath = properties.getProperty(key);
                //反射获取对象
                Object value = Class.forName(beanPath).newInstance();
                //把key和value存入容器之中
                beans.put(key,value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }finally {

        }

    }

    public static Object getBean(String beanPath){
        return beans.get(beanPath);
    }
}
