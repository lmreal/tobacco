package com.lm.tobacco.util;

import java.io.File;
import javax.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

/**
 * @author liming356
 * @since 2018/9/27/027
 */
@Component
public class MailUtil {

  @Autowired private JavaMailSender mailSender;

  @Value("${spring.mail.username}")
  private String sender;

  /**
   * 发送简单文本邮件
   *
   * @param receiver
   * @param content
   */
  public void sendHtmlMail(String receiver, String content) {
    MimeMessage message = null;
    try {
      message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(sender);
      helper.setTo(receiver);
      helper.setSubject("标题：发送Html内容");

      StringBuffer sb = new StringBuffer();
      sb.append("<h1>大标题-h1</h1>")
          .append("<p style='color:#F00'>红色字</p>")
          .append("<p style='text-align:right'>右对齐</p>");
      helper.setText(sb.toString(), true);
    } catch (Exception e) {
      e.printStackTrace();
    }
    mailSender.send(message);
  }

  /**
   * 发送Html邮件
   *
   * @param receiver
   * @param content
   */
  public void sendSimpleMail(String receiver, String content) {
    SimpleMailMessage message = new SimpleMailMessage();
    message.setFrom(sender);
    message.setTo(receiver);
    message.setSubject("主题：简单邮件");
    message.setText(content);
    mailSender.send(message);
    System.out.println("run");
  }

  /**
   * 发送带附件的邮件
   *
   * @param receiver
   * @param content
   */
  public void sendAttachmentsMail(String receiver, String content) {
    MimeMessage message = null;
    try {
      message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(sender);
      helper.setTo(receiver);
      helper.setSubject("主题：带附件的邮件");
      helper.setText("带附件的邮件内容");
      // 注意项目路径问题，自动补用项目路径
      FileSystemResource file =
          new FileSystemResource(new File("src/main/resources/static/image/picture.jpg"));
      // 加入邮件
      helper.addAttachment("图片.jpg", file);
    } catch (Exception e) {
      e.printStackTrace();
    }
    mailSender.send(message);
  }

  /**
   * 发送带静态资源的邮件
   *
   * @param receiver
   * @param content
   */
  public void sendInlineMail(String receiver, String content) {
    MimeMessage message = null;
    try {
      message = mailSender.createMimeMessage();
      MimeMessageHelper helper = new MimeMessageHelper(message, true);
      helper.setFrom(sender);
      helper.setTo(receiver);
      helper.setSubject("主题：带静态资源的邮件");
      // 第二个参数指定发送的是HTML格式,同时cid:是固定的写法
      helper.setText("<html><body>带静态资源的邮件内容 图片:<img src='cid:picture' /></body></html>", true);

      FileSystemResource file =
          new FileSystemResource(new File("src/main/resources/static/image/picture.jpg"));
      helper.addInline("picture", file);
    } catch (Exception e) {
      e.printStackTrace();
    }
    mailSender.send(message);
  }
}
