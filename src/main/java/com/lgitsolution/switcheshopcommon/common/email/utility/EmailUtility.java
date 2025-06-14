
package com.lgitsolution.switcheshopcommon.common.email.utility;

import java.util.Properties;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import com.lgitsolution.switcheshopcommon.email.preferences.dto.EmailPreferencesDto;

public class EmailUtility {

  public static JavaMailSender getJavaMailSender(EmailPreferencesDto emailPreferencesDto) {
    JavaMailSenderImpl javaMailSenderImpl = new JavaMailSenderImpl();
    javaMailSenderImpl.setHost(emailPreferencesDto.getConfig().get("host"));
    javaMailSenderImpl.setUsername(emailPreferencesDto.getEmailId());
    javaMailSenderImpl.setPassword(emailPreferencesDto.getPassword());
    javaMailSenderImpl.setPort(Integer.parseInt(emailPreferencesDto.getConfig().get("port")));
    Properties emailProperties = javaMailSenderImpl.getJavaMailProperties();
    emailProperties.setProperty("username", emailPreferencesDto.getEmailId());
    emailProperties.setProperty("mail.smtp.starttls.enable", "true");
    emailProperties.setProperty("mail.smtp.auth", "true");
    emailProperties.setProperty("mail.transport.protocol", "smtp");
    emailProperties.setProperty("mail.smtp.connectiontimeout", "5000");
    emailProperties.setProperty("mail.smtp.timeout", "5000");
    emailProperties.setProperty("mail.smtp.writetimeout", "5000");
    emailProperties.put("mail.smtp.host", emailPreferencesDto.getConfig().get("host"));
    emailProperties.put("mail.smtp.socketFactory.port", emailPreferencesDto.getConfig().get(
            "port"));
    emailProperties.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
    emailProperties.put("mail.smtp.auth", true);
    emailProperties.put("mail.smtp.port", emailPreferencesDto.getConfig().get("port"));
    return javaMailSenderImpl;
  }

}
