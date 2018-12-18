package com.pharmaking.order.config.monitor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

public class AlarmProducer {

    @Autowired
    private JavaMailSender mailSender;

    public void send(String projectName, String message1) {
        //TODO insertDB
        //TODO mobile/email

        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("dyc87112@qq.com");
        message.setTo("dyc87112@qq.com");
        message.setSubject("主题：简单邮件");
        message.setText("测试邮件内容");

        mailSender.send(message);
    }

}