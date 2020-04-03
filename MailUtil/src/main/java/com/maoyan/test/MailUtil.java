package com.maoyan.test;

import javax.mail.*;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;
/**
 * @author Maoyan
 * @data 2020/3/27 20:43
 * @Version 1.0.0
 */
public class MailUtil {
    private static final String USER="1071352028@qq.com";
    private static final String PASSWORD="hack521478963.";

    public static boolean sendMail(String to,String text,String title) throws MessagingException {
        final Properties properties = new Properties();
        properties.put("mail.smtp.auth", "true");
        properties.put("mail.smtp.host", "smtp.qq.com");

        //发件人账号
        properties.put("mail.user",USER);
        //发件人密码
        properties.put("mail.password",PASSWORD);

        //构造权限信息,
        Authenticator authenticator = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                String username = properties.getProperty("mail.user");
                String password = properties.getProperty("mail.passowrd");
                return new PasswordAuthentication(username,password);
            }
        };
        //使用环境属性与授权信息，创建邮件会话
        Session mailsession = Session.getInstance(properties,authenticator);
        //创建邮件信息
        MimeMessage message = new MimeMessage(mailsession);
        //设置发件人
        String username = properties.getProperty("mail.user");
        InternetAddress form = new InternetAddress(username);
        message.setFrom(form);

        //设置收件人
        InternetAddress toAddress = new InternetAddress(to);
        message.setRecipients(Message.RecipientType.TO,to);

        //设置邮件标题
        message.setSubject(title);

        //设置内容体
        message.setContent(text,"text/html;charset=UTF-8");
        //发送邮件
        Transport.send(message);
        return true;
    }

    public static void main() throws MessagingException {
        MailUtil.sendMail("820244680@qq.com","hello","测试邮件");
        System.out.println("发送完毕");
    }
}
