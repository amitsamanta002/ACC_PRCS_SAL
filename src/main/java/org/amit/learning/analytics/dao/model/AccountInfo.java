package org.amit.learning.analytics.dao.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;

@Component
public class AccountInfo {

    @JsonProperty(value = "customernumber")
    private int customerNumber;

    @JsonProperty(value = "customerName")
    private String customerName;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public AccountInfo() {
    }

    @Override
    public String toString() {
        return "AccountInfo{" +
                "customerName='" + customerName + '\'' +
                ", customerNumber=" + customerNumber +
                '}';
    }
}

