package org.amit.learning.analytics.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;

@Configuration
@ComponentScan("{org.amit.learning.analytics}")
public class BaseConfig {

    @Bean
    public SimpleMailMessage simpleMailMessage(){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo("kuhelisamanta91@gmail.com");
        message.setCc("amitsamanta002@gmail.com");
        message.setFrom("mail.nutsbit@gmail.com");
        message.setSubject("System Generated Email from Amit-Samanta's program - nutsbit.");
        message.setText("Hello!!! Don't panic .. this is a system generated email.. please ignore this email..");
        return message;
    }


}
