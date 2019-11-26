package org.amit.learning.analytics.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService {
    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    @Autowired
    private SimpleMailMessage message;

    @Autowired
    private JavaMailSender mailSender;

    public void sendEmail(){
        mailSender.send(message);
        log.info("Email send to reciver.. please check..");

    }

}
