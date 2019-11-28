package org.amit.learning.analytics.service.impl;

import org.amit.learning.analytics.dao.mapper.OrderRepositoryDao;
import org.amit.learning.analytics.dao.model.EmailData;
import org.amit.learning.analytics.mailthread.MailService;
import org.amit.learning.analytics.model.OrderResponse;
import org.amit.learning.analytics.service.IOrderProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@ConfigurationProperties
@PropertySource("classpath:message.properties")
@Component
public class OrderProcessingServiceImpl implements IOrderProcessingService {

    private final static Logger log = LoggerFactory.getLogger(OrderProcessingServiceImpl.class);

    @Autowired
    private OrderResponse orderResponse;

    @Autowired
    private ThreadPoolTaskExecutor taskExecutor;

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private OrderRepositoryDao orderRepositoryDao;

    //Value will be coming from meesage.properties with standered format...

    private String serviceSuccessComment;
    private String serviceErrorComment;

    @Override
    public OrderResponse updateAndProcessOrderStatus(int orderNumber, String orderStatus, String user) {
        int numRowUpdated = orderRepositoryDao.updateOrderStatus(orderStatus,orderNumber,user);
        if(numRowUpdated > 0){
            log.info("Number of row updated for OrderNumber{} rows {}",orderNumber,numRowUpdated);
            orderResponse.setResponseCode(00);
            orderResponse.setResponseStatusCode(0000);
            orderResponse.setResponseMessage("Number of Row Updated for orderNumber = "+orderNumber + " is =" + numRowUpdated);
            orderResponse.setResponseComments(serviceSuccessComment);
        /*
        Calling Email Thread for send email to user for status update..
         */
            EmailData emailData = generateEmailDetails(orderNumber,orderStatus);

            log.info("emailData={}",emailData.toString());
            log.info("Email Thread Invoke here..");
            taskExecutor.execute(new MailService(mailSender,emailData));

        }else {
            log.info("Service is down for internal error.. no status updated for OrderNumber = {}",orderNumber);
            orderResponse.setResponseCode(88);
            orderResponse.setResponseStatusCode(8888);
            orderResponse.setResponseMessage("Service leverl System Error");
            orderResponse.setResponseComments(serviceErrorComment);
        }

        return orderResponse;
    }


    private EmailData generateEmailDetails(int orderNumber,String orderStatus){

      //Calling DAO to get configuration from database.

        EmailData emailData = orderRepositoryDao.selectCustmerEmailData(orderNumber);
        emailData.setEmailSubject(orderRepositoryDao.getSelectEmailSubject());

     //Creating email text dynamically for the user....

        String emailText = "Hi "+emailData.getToaddFname()+" "+emailData.getToaddLname()+", \n"+
                "Your Order number "+orderNumber + " now in " +orderStatus +" status. \n\n\n"+
                "Please contact to custmer care if you want more detail... \n\n"+
                "Custmer care mobile Number = (+91) 833-186-2438. \n\n\n\n\n"+
                "Thank You, \n"+"Nutsbit Application Team.\n Mumbai-400101";

        emailData.setEmailTextBody(emailText);

        return emailData;
    }

 //Getter and Setter for Standered message from message.properties files.
    public String getServiceSuccessComment() {
        return serviceSuccessComment;
    }

    public void setServiceSuccessComment(String serviceSuccessComment) {
        this.serviceSuccessComment = serviceSuccessComment;
    }

    public String getServiceErrorComment() {
        return serviceErrorComment;
    }

    public void setServiceErrorComment(String serviceErrorComment) {
        this.serviceErrorComment = serviceErrorComment;
    }
}
