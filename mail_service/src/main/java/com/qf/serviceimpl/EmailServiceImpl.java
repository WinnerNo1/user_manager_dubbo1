package com.qf.serviceimpl;

import com.alibaba.dubbo.config.annotation.Service;
import com.qf.entity.Email;
import com.qf.entity.User;
import com.qf.service.IEmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.Date;

/**
 * @version 1.0
 * @userzhangliang
 * @date2019/6/29 18:32
 */
@Service
public class EmailServiceImpl implements IEmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public int getcode(Email email) {
        //创建一封邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //创建一个Spring提供的邮件帮助对象
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置发送方
        try {
            messageHelper.setFrom("verygoodwlk@sina.cn");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置接收方
        //to - 普通接收方
        //cc - 抄送方
        //bcc - 密送方
        try {
            messageHelper.addTo(email.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置标题
        try {
            messageHelper.setSubject("验证码");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        int code=0;

        //设置内容
        try {
            code=(int)((Math.random()*9+1)*1000);
            messageHelper.setText("您的验证码为："+code);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置时间
        try {
            messageHelper.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        //发送邮件
        javaMailSender.send(mimeMessage);

        return code;
    }

    @Override
    public void find(User user) {
        //创建一封邮件
        MimeMessage mimeMessage = javaMailSender.createMimeMessage();

        //创建一个Spring提供的邮件帮助对象
        MimeMessageHelper messageHelper = null;
        try {
            messageHelper = new MimeMessageHelper(mimeMessage, true);
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置发送方
        try {
            messageHelper.setFrom("verygoodwlk@sina.cn");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置接收方
        //to - 普通接收方
        //cc - 抄送方
        //bcc - 密送方
        try {
            messageHelper.addTo(user.getEmail());
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置标题
        try {
            messageHelper.setSubject("找回密码");
        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置内容
        try {
            messageHelper.setText("请点击<a href='http://127.0.0.1:8080/user/find'>这里</a>找回密码~", true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        //设置时间
        try {
            messageHelper.setSentDate(new Date());
        } catch (MessagingException e) {
            e.printStackTrace();
        }
        //发送邮件
        javaMailSender.send(mimeMessage);

    }
}
