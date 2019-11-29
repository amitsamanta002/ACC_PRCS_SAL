package org.amit.learning.analytics.config;


import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.cache.ehcache.EhCacheManagerFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

@Configuration
@ComponentScan("{org.amit.learning.analytics}")
@EnableCaching
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

//Cache Server Bean created here....
    @Bean
    public CacheManager cacheManager(){
        return new EhCacheCacheManager(ehCacheManagerFactoryBean().getObject());
    }

    private EhCacheManagerFactoryBean ehCacheManagerFactoryBean() {
        EhCacheManagerFactoryBean ehCacheManagerFactoryBean = new EhCacheManagerFactoryBean();
        ehCacheManagerFactoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
        ehCacheManagerFactoryBean.setShared(true);

        return ehCacheManagerFactoryBean;
    }
}
