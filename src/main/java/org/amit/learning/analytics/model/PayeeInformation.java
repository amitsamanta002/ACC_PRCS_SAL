package org.amit.learning.analytics.model;


import org.springframework.stereotype.Component;

@Component
public class PayeeInformation {
    private int toAccountNumber;
    private String toAccountName,toAddressLine1,toAddressLine2,toCity,toState,toPostalCode,toCountry;

    public PayeeInformation() {
    }

    @Override
    public String toString() {
        return "PayeeInformation{" +
                "toAccountNumber=" + toAccountNumber +
                ", toAccountName='" + toAccountName + '\'' +
                ", toAddressLine1='" + toAddressLine1 + '\'' +
                ", toAddressLine2='" + toAddressLine2 + '\'' +
                ", toCity='" + toCity + '\'' +
                ", toState='" + toState + '\'' +
                ", toPostalCode='" + toPostalCode + '\'' +
                ", toCountry='" + toCountry + '\'' +
                '}';
    }

    public int getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(int toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public String getToAccountName() {
        return toAccountName;
    }

    public void setToAccountName(String toAccountName) {
        this.toAccountName = toAccountName;
    }

    public String getToAddressLine1() {
        return toAddressLine1;
    }

    public void setToAddressLine1(String toAddressLine1) {
        this.toAddressLine1 = toAddressLine1;
    }

    public String getToAddressLine2() {
        return toAddressLine2;
    }

    public void setToAddressLine2(String toAddressLine2) {
        this.toAddressLine2 = toAddressLine2;
    }

    public String getToCity() {
        return toCity;
    }

    public void setToCity(String toCity) {
        this.toCity = toCity;
    }

    public String getToState() {
        return toState;
    }

    public void setToState(String toState) {
        this.toState = toState;
    }

    public String getToPostalCode() {
        return toPostalCode;
    }

    public void setToPostalCode(String toPostalCode) {
        this.toPostalCode = toPostalCode;
    }

    public String getToCountry() {
        return toCountry;
    }

    public void setToCountry(String toCountry) {
        this.toCountry = toCountry;
    }
}
