package org.amit.learning.analytics.dao.model;

import org.springframework.stereotype.Component;

import java.sql.Timestamp;
import java.util.Date;

public class Order {

    private int orderNumber,customerNumber;
    private Date orderDate,requiredDate,shippedDate;
    private String status,comments,updateByUser;

    public String getUpdateByUser() {
        return updateByUser;
    }

    public void setUpdateByUser(String updateByUser) {
        this.updateByUser = updateByUser;
    }

    public Order(int orderNumber, int customerNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments, String updateByUser) {
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
        this.updateByUser = updateByUser;
    }

    public Order(int orderNumber, int customerNumber, Date orderDate, Date requiredDate, Date shippedDate, String status, String comments) {
        this.orderNumber = orderNumber;
        this.customerNumber = customerNumber;
        this.orderDate = orderDate;
        this.requiredDate = requiredDate;
        this.shippedDate = shippedDate;
        this.status = status;
        this.comments = comments;
    }

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public void setCustomerNumber(int customerNumber) {
        this.customerNumber = customerNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getRequiredDate() {
        return requiredDate;
    }

    public void setRequiredDate(Date requiredDate) {
        this.requiredDate = requiredDate;
    }

    public Date getShippedDate() {
        return shippedDate;
    }

    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderNumber=" + orderNumber +
                ", customerNumber=" + customerNumber +
                ", orderDate=" + orderDate +
                ", requiredDate=" + requiredDate +
                ", shippedDate=" + shippedDate +
                ", status='" + status + '\'' +
                ", comments='" + comments + '\'' +
                ", updateByUser='" + updateByUser + '\'' +
                '}';
    }
}
