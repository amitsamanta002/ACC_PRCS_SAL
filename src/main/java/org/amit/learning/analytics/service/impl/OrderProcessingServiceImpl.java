package org.amit.learning.analytics.service.impl;

import org.amit.learning.analytics.dao.mapper.OrderRepositoryDao;
import org.amit.learning.analytics.mailthread.MailService;
import org.amit.learning.analytics.model.OrderResponse;
import org.amit.learning.analytics.service.IOrderProcessingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

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

    @Override
    public OrderResponse updateAndProcessOrderStatus(int orderNumber, String orderStatus, String user) {
        int numRowUpdated = orderRepositoryDao.updateOrderStatus(orderStatus,orderNumber,user);
        if(numRowUpdated > 0){
            log.info("Number of row updated for OrderNumber{} rows {}",orderNumber,numRowUpdated);
            orderResponse.setResponseCode(00);
            orderResponse.setResponseStatusCode(0000);
            orderResponse.setResponseMessage("Number of Row Updated for orderNumber = "+orderNumber + " is =" + numRowUpdated);
            orderResponse.setResponseComments("Rescords are updated and Email will notify to user with current status");
        /*
        Calling Email Thread for send email to user for status update..
         */
            log.info("Email Thread Invoke here..");
            taskExecutor.execute(new MailService(mailSender));

        }else {
            log.info("Service is down for internal error.. no status updated for OrderNumber = {}",orderNumber);
            orderResponse.setResponseCode(88);
            orderResponse.setResponseStatusCode(8888);
            orderResponse.setResponseMessage("Service leverl System Error");
            orderResponse.setResponseComments("Wait for sometime and retry again");
        }

        return orderResponse;
    }
}
