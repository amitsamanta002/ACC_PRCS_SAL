package org.amit.learning.analytics.dao.model;

public class AccountDetails {

    private int customerNumber,accountNumber;
    private String accountCatgorie;
    private double currentBalance;
    private String createTimestamp;

    public AccountDetails() {
    }

    @Override
    public String toString() {
        return "AccountDetails{" +
                "customerNumber=" + customerNumber +
                ", accountNumber=" + accountNumber +
                ", accountCatgorie='" + accountCatgorie + '\'' +
                ", currentBalance=" + currentBalance +
                ", createTimestamp='" + createTimestamp + '\'' +
                '}';
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(int accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountCatgorie() {
        return accountCatgorie;
    }

    public void setAccountCatgorie(String accountCatgorie) {
        this.accountCatgorie = accountCatgorie;
    }

    public double getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(double currentBalance) {
        this.currentBalance = currentBalance;
    }

    public String getCreateTimestamp() {
        return createTimestamp;
    }

    public void setCreateTimestamp(String createTimestamp) {
        this.createTimestamp = createTimestamp;
    }
}
