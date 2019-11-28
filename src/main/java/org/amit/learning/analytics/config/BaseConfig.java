package org.amit.learning.analytics.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

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

    /*
    Thread configuration for multiThreads. This is the configuration for thread pool.
     */

    @Bean
    public ThreadPoolTaskExecutor taskExecutor(){
        ThreadPoolTaskExecutor poolTaskExecutor = new ThreadPoolTaskExecutor();
        poolTaskExecutor.setCorePoolSize(5);
        poolTaskExecutor.setMaxPoolSize(16);
        poolTaskExecutor.setWaitForTasksToCompleteOnShutdown(true);

        return  poolTaskExecutor;
    }


}
