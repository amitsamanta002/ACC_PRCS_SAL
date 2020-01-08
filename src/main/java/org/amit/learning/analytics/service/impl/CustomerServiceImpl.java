package org.amit.learning.analytics.service.impl;

import org.amit.learning.analytics.dao.mapper.CustomerRepositoryDao;
import org.amit.learning.analytics.dao.model.*;
import org.amit.learning.analytics.model.PayeeInformation;
import org.amit.learning.analytics.model.RequestCustomerInfo;
import org.amit.learning.analytics.service.ICustomersService;
import org.amit.learning.analytics.service.ProcessKey;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class CustomerServiceImpl implements ICustomersService {

    private final static Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerRepositoryDao customerRepositoryDao;

    @Autowired
    private CustomerInfo customerInfo;

    @Autowired
    private PayeeInformation payeeInformation;

    @Override
    public List<Customer> getCustomerListbyRequest(String city,String state, String postalCode,String country) {

        ProcessKey processKey = new ProcessKey();

//intermediate operation for populating data to process....

        if(city==null)
            processKey.setKeyCity("");
        else
            processKey.setKeyCity(city.trim());

        if(state==null)
            processKey.setKeyState("");
        else
            processKey.setKeyState(state.trim());

        if(postalCode==null)
            processKey.setKeyPostalCode("");
        else
            processKey.setKeyPostalCode(postalCode.trim());

        if(country==null)
            processKey.setKeyCountry("");
        else
            processKey.setKeyCountry(country.trim());


        List<Customer> customers = customersfromDB(processKey);

        List<Customer> customerList = (List <Customer>) customers.parallelStream().
          filter(customer -> {
            if(processKey.getKeyCity().isEmpty())
                return true;
            else {
                if (customer.getCity().equalsIgnoreCase(processKey.getKeyCity()))
                    return true;
                else
                    return false;
            }
            }).
          filter(customer -> {
            if(processKey.getKeyCountry().isEmpty())
                return true;
            else{
                if(customer.getCountry().equalsIgnoreCase(processKey.getKeyCountry()))
                    return true;
                else
                    return false;
            }
            }).
          filter(customer ->{
             if(processKey.getKeyPostalCode().isEmpty())
                 return true;
             else{
                 if(customer.getPostalCode().equalsIgnoreCase(processKey.getKeyPostalCode()))
                     return true;
                 else
                     return false;
             }
            }).
           filter(customer -> {
               if(processKey.getKeyState().isEmpty())
                   return true;
               else{
                   if(customer.getState().equalsIgnoreCase(processKey.getKeyState()))
                       return true;
                   else
                       return false;
               }
           }).collect(Collectors.toList());


        return customerList;
    }

    @Override
    public List <AccountInfo> getCustomerNameandIDFromDB() {
        List<AccountInfo> customerSearches = customerRepositoryDao.getAllCustomerNameandID();
        return customerSearches;
    }

    @Override
    public Customer buildCustomerInformationbyId(int customerNumber){
        //Getting customer basic information.
        Customer customer = customerRepositoryDao.getCustomerDetailsById(customerNumber);

        if(customer == null)
            logger.info("No customer records found on DB for customer id = "+customerNumber);

        return customer;
    }

    @Override
    public AccountDetails getCustomerAccountInfomationbyId(int customerNumber) {
        AccountDetails accountDet =  customerRepositoryDao.getAccountDetailsbyID(customerNumber);
        logger.info(accountDet.toString());
        return accountDet;
    }

    @Override
    public PayeeInformation getPayeeInformation(int accountNumber) throws RuntimeException {
        PayeeDetail payeeDetail = new PayeeDetail();

        payeeDetail = customerRepositoryDao.getPayeeInformationFromDB(accountNumber);

        if(payeeDetail == null) {
            logger.error("Calling to DB fail for Payee information");
            throw new NullPointerException("DB data not found for this account");
        }else{
            payeeInformation.setToAccountNumber(accountNumber);
            payeeInformation.setToAccountName(payeeDetail.getCustomerFirstName()
                                        + " " + payeeDetail.getCustomerLastName());
            payeeInformation.setToAddressLine1(payeeDetail.getAddressLine1());
            payeeInformation.setToAddressLine2(payeeDetail.getAddressLine2());
            payeeInformation.setToCity(payeeDetail.getCity());
            payeeInformation.setToCountry(payeeDetail.getCountry());
            payeeInformation.setToPostalCode(payeeDetail.getPostalCode());
            payeeInformation.setToState(payeeDetail.getState());
        }

        return payeeInformation;
    }

    @Override
    public int addnewCustomer(RequestCustomerInfo requestCustomerInfo) {
        if(requestCustomerInfo == null){
            logger.info("Incorrect information send to add");
            return 0;
        }else{
            customerInfo.setContactFirstName(requestCustomerInfo.getCustomerFirstName());
            customerInfo.setContactLastName(requestCustomerInfo.getCustomerLastName());
            customerInfo.setAddressLine1(requestCustomerInfo.getAddressLine1());
            customerInfo.setAddressLine2(requestCustomerInfo.getAddressLine2());
            customerInfo.setCity(requestCustomerInfo.getCity());
            customerInfo.setCountry(requestCustomerInfo.getCountry());
            customerInfo.setPostalCode(requestCustomerInfo.getPostalCode());
            customerInfo.setState(requestCustomerInfo.getState());
            customerInfo.setPhone(requestCustomerInfo.getPhone());
            customerInfo.setEmail(requestCustomerInfo.getEmail());
        }

        logger.info("Record added"+customerInfo.toString());

        return customerRepositoryDao.addCustomer(customerInfo);
    }

    @Cacheable(value = "CustomerCache", key="#key.hashCode()")
    public List<Customer> customersfromDB(ProcessKey key){
        return customerRepositoryDao.getAllCustomerDetails();
    }
}
