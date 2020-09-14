package com.czj.myShop.utils;

import com.czj.myShop.entity.User;

import javax.mail.Address;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;


/**
 * 发送邮件时候： 向运维:维护服务器Linux
 * 索要：
 * 1.smtp服务器地址,smtp.163.com
 * 2.发送邮件的端口号:默认25
 * 3.发件人的账号和密码
 *
 * @author gyf
 *
 */
public class SendJMailNew {
    static final String smtphost = "smtp.163.com";//smtp服务器地址
    static final String from = "chenzujian1713@163.com"; // 邮件发送人的邮件地址
    static final String username = "chenzujian1713@163.com"; // 发件人的邮件帐户
    static final String password = "VQXEKNBEMPEXRPQT"; // 发件人的邮件密码
 
    /**
     *
     * @param user
     *            收件用户
     * @return
     */
    public static boolean sendMail(User user) {
        // 邮件接收人的邮件地址
        String to = user.getEmail();
        // 定义Properties对象,设置环境信息
        Properties props = System.getProperties();
 
        // 设置邮件服务器的地址
        props.setProperty("mail.smtp.host", smtphost); // 指定的smtp服务器
        props.setProperty("mail.smtp.auth", "true");
        props.setProperty("mail.transport.protocol", "smtp");// 设置发送邮件使用的协议
        props.put("mail.smtp.starttls.enable", "true");
 
        // 创建Session对象,session对象表示整个邮件的环境信息
        Session session = Session.getInstance(props);
        // 设置输出调试信息
        session.setDebug(true);
        try {
            // Message的实例对象表示一封电子邮件
            MimeMessage message = new MimeMessage(session);
            // 设置发件人的地址
            message.setFrom(new InternetAddress(from));
            // 设置主题
            message.setSubject("用户激活");
            // 设置邮件的文本内容
            // message.setText("Welcome to JavaMail World!");
            message.setContent("<a  href="+GenerateLinkUtils.generateActivateLink(user)+">"+user.getUsername()+
                    "先生/女士您好，请点击此链接激活账号"
                    +"</a>","text/html;charset=utf-8");


            // 设置附件
            // message.setDataHandler(dh);
 
            // 从session的环境中获取发送邮件的对象
            Transport transport = session.getTransport();
            // 连接邮件服务器
            transport.connect(smtphost, 25, username, password);
            // 设置收件人地址,并发送消息
            transport.sendMessage(message, new Address[] { new InternetAddress(to) });
            transport.close();
            return true;
        } catch (MessagingException e) {
            e.printStackTrace();
            return false;
        }
    }


}