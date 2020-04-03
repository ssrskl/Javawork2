package com.maoyan.test;

import com.maoyan.dao.Userdao;
import com.maoyan.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author Maoyan
 * @data 2020/3/27 13:07
 * @Version 1.0.0
 */
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //读取配置文件
        InputStream in = Resources.getResourceAsStream("SqlMapConfig.xml");
        //创建工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(in);
        //使用工厂生产的Session对象
        SqlSession session = factory.openSession();
        Userdao userdao = session.getMapper(Userdao.class);
        User user = userdao.findFristUser();
        System.out.println("输出："+user.getUname());
        List<User> users = userdao.findAllUser();
        for (User u : users) {
            System.out.println(u);
        }
        session.close();
        in.close();
    }

}
