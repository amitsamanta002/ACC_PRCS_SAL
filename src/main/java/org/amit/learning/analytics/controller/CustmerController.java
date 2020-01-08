package org.amit.learning.analytics.controller;

import org.amit.learning.analytics.dao.model.AccountDetails;
import org.amit.learning.analytics.dao.model.Customer;
import org.amit.learning.analytics.dao.model.AccountInfo;
import org.amit.learning.analytics.dao.model.CustomerInfo;
import org.amit.learning.analytics.exception.BadDataInput;
import org.amit.learning.analytics.model.PayeeInformation;
import org.amit.learning.analytics.model.RequestCustomerInfo;
import org.amit.learning.analytics.model.TestResponse;
import org.amit.learning.analytics.service.ICustomersService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustmerController {

    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private ICustomersService iCustomersService;


    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/inventory/customers")
    public List<Customer> CustomerDetails(@RequestParam(value = "city",required = false) String city,
                                          @RequestParam(value = "state",required = false)String state,
                                          @RequestParam(value = "postalCode",required = false) String postalCode,
                                          @RequestParam(value = "country",required = false) String country) {

        return  iCustomersService.getCustomerListbyRequest(city,state,postalCode,country);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/inventory/test")
    public TestResponse TestClass(){
        TestResponse testResponse = new TestResponse();
        testResponse.setId(100);
        testResponse.setName("Amit Samanta");
        testResponse.setAddress("Mumbai-400101");

        return testResponse;
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/inventory/customer/search")
    public List<AccountInfo> CustomerSeachAutoComplete(){

        logger.info("Customer type ahade search.");

        return iCustomersService.getCustomerNameandIDFromDB();
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/inventory/customer/data/{customerNumber}")
    public Customer getCustomerDetailsByID(@PathVariable("customerNumber") int customerNumber){
        if(customerNumber <= 0)
            logger.info("incorrect customet number");

        return iCustomersService.buildCustomerInformationbyId(customerNumber);

    }

    @CrossOrigin(origins = "http://localhost:4200")
    @PostMapping(path = "/inventory/customer/add", consumes={"application/json"})
    public int addNewCustomer(@RequestBody RequestCustomerInfo requestCustomerInfo){
        logger.info("incoming message: "+requestCustomerInfo.toString());

        return iCustomersService.addnewCustomer(requestCustomerInfo);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/inventory/customer/accountinfo/{customerNumber}")
    public AccountDetails getAccountDetailsByCustomerNumber(@PathVariable("customerNumber") int customerNumber){
        if(customerNumber <= 0)
            logger.info("incorrect customet number for accoutn search.");

        return iCustomersService.getCustomerAccountInfomationbyId(customerNumber);
    }

    @CrossOrigin(origins = "http://localhost:4200")
    @RequestMapping("/inventory/customer/toaccountinfo/{accountNumber}")
    public PayeeInformation getPayeeInformation(@PathVariable("accountNumber") int accountNumber) throws Exception {
        logger.info("Details fetch for account number="+accountNumber);
        if(accountNumber <= 0){
            logger.error("Incorrect Account number.. please correct the account number then consume the service");
            throw new BadDataInput("Bad Data is coming from request.");
        }

        return iCustomersService.getPayeeInformation(accountNumber);
    }
}
