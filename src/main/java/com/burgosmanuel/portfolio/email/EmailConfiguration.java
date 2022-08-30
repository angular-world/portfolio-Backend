
package com.burgosmanuel.portfolio.email;

import java.util.Properties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

@Configuration
public class EmailConfiguration {
    
    @Bean
    public JavaMailSender getJavaMailSender() {
        // Implementamos el Mail Sender de Spring Mail
        JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
        // Configuramos el servidor SMTP
        mailSender.setHost("smtp.gmail.com");
        mailSender.setPort(587);
        // Cuenta SMTP
        mailSender.setUsername("trapecioinv@gmail.com");
        mailSender.setPassword("jgssuepkwyudrbtq");
        // Configuramos las propiedades del mailsender para que coincida con el de GMAIL
        Properties props = mailSender.getJavaMailProperties();
        props.put("mail.transport.protocol", "smtp");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.debug", "true");

        return mailSender;
    }
}
