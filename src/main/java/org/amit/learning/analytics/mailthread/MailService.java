package org.amit.learning.analytics.mailthread;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service("emailService")
public class MailService implements Runnable {

    private JavaMailSender mailSender;

    public MailService( JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    private static final Logger log = LoggerFactory.getLogger(MailService.class);


    public void sendEmail(){

        SimpleMailMessage  message = new SimpleMailMessage();
        message.setTo("mail.nutsbit@gmail.com");
        message.setCc("mail.nutsbit@gmail.com");
        message.setFrom("mail.nutsbit@gmail.com");
        message.setSubject("System Generated Email from Amit-Samanta's program - nutsbit.");
        message.setText("Hello!!! Don't panic .. this is a system generated email.. please ignore this email..");
        mailSender.send(message);

        log.info("Order is dispatched email has send.. please check..");

    }

    @Override
    public void run(){
        log.info("Sending email to user using from seperate Thread");
        sendEmail();
    }

}
