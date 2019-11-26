package org.amit.learning.analytics.controller;


import org.amit.learning.analytics.dao.mapper.PsnRepository;
import org.amit.learning.analytics.dao.model.PsnInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AnalyticsController {

    @Autowired
    private JavaMailSender mailSender;

    @Autowired
    private PsnRepository psnRepository;

    @RequestMapping("/analytics/process")
    public List<PsnInfo> ProcessingData(){
        return  psnRepository.getPsnInfoAll();
    }
}
