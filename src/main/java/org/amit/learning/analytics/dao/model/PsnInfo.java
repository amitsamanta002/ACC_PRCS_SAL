package org.amit.learning.analytics.dao.model;


import org.springframework.stereotype.Component;

public class PsnInfo {

    private double id;
    private String accNumber,holderName,holderAddress;

    public double getId() {
        return id;
    }

    public void setId(double id) {
        this.id = id;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public void setAccNumber(String accNumber) {
        this.accNumber = accNumber;
    }

    public String getHolderName() {
        return holderName;
    }

    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }

    public String getHolderAddress() {
        return holderAddress;
    }

    public void setHolderAddress(String holderAddress) {
        this.holderAddress = holderAddress;
    }

    public PsnInfo(double id, String accNumber, String holderName, String holderAddress) {
        this.id = id;
        this.accNumber = accNumber;
        this.holderName = holderName;
        this.holderAddress = holderAddress;
    }

    @Override
    public String toString() {
        return "PsnInfo{" +
                "id=" + id +
                ", accNumber='" + accNumber + '\'' +
                ", holderName='" + holderName + '\'' +
                ", holderAddress='" + holderAddress + '\'' +
                '}';
    }
}
