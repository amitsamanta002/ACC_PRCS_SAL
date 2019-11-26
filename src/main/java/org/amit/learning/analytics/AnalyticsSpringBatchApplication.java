package org.amit.learning.analytics;

import org.amit.learning.analytics.service.MailService;
import org.apache.logging.log4j.spi.LoggerContext;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootApplication
@EnableAutoConfiguration
@MapperScan("org.amit.learning.analytics.dao.mapper")
public class AnalyticsSpringBatchApplication {

	private static final Logger logger = LoggerFactory.getLogger(AnalyticsSpringBatchApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(AnalyticsSpringBatchApplication.class, args);
	}



}
