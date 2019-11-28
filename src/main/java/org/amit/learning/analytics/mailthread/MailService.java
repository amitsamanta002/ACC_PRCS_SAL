package org.amit.learning.analytics.mailthread;

import org.amit.learning.analytics.dao.model.EmailData;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class MailService implements Runnable {

    private JavaMailSender mailSender;

    private EmailData emailData;   //contains all email related data...

    public MailService(JavaMailSender mailSender, EmailData emailData) {
        this.mailSender = mailSender;
        this.emailData = emailData;
    }

    private static final Logger log = LoggerFactory.getLogger(MailService.class);


    public void sendEmail(){

        SimpleMailMessage  message = new SimpleMailMessage();
        message.setTo(emailData.getEmailTo());
        message.setCc(emailData.getEmailTo());
        message.setFrom("mail.nutsbit@gmail.com");
        message.setSubject(emailData.getEmailSubject());
        message.setText(emailData.getEmailTextBody());

        log.info("email message:"+message.toString());

        mailSender.send(message);

        log.info("Order is dispatched email has send.. please check..");

    }

    @Override
    public void run(){
        log.info("Sending email to user using from seperate Thread");
        sendEmail();
    }

}
