package com.maoyan.test;

import com.maoyan.Util.MailUtils;

import javax.mail.MessagingException;

/**
 * @author Maoyan
 * @data 2020/3/27 20:43
 * @Version 1.0.0
 */
public class Test {
    public static void main(String[] args) throws MessagingException {
        for (int i = 0;i<10&&MailUtils.sendMail("820244680@qq.com", "cs", "cs");i++) {
        }
    }
}
