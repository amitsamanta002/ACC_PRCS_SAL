package org.amit.learning.analytics.dao.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.stereotype.Component;


@Component

public class CustomerInfo {

    @JsonBackReference
    @JsonProperty(value = "customerLastName")
    private String customerLastName;

    @JsonBackReference
    @JsonProperty(value = "customerFirstName")
    private String customerFirstName;

    @JsonBackReference
    @JsonProperty(value = "phone")
    private String phone;

    @JsonBackReference
    @JsonProperty(value = "addressLine1")
    private String addressLine1;

    @JsonBackReference
    @JsonProperty(value = "addressLine1")
    private String addressLine2;

    @JsonBackReference
    @JsonProperty(value = "city")
    private String city;

    @JsonBackReference
    @JsonProperty(value = "state")
    private String state;

    @JsonBackReference
    @JsonProperty(value = "postalCode")
    private String postalCode;

    @JsonBackReference
    @JsonProperty(value = "country")
    private String country;

    @JsonBackReference
    @JsonProperty(value = "email")
    private String email;

    public CustomerInfo() {

    }

    public String getContactLastName() {
        return customerLastName;
    }

    public void setContactLastName(String contactLastName) {
        this.customerLastName = contactLastName;
    }

    public String getContactFirstName() {
        return customerFirstName;
    }

    public void setContactFirstName(String contactFirstName) {
        this.customerFirstName = contactFirstName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "  customerLastName='" + customerLastName + '\'' +
                ", customerFirstName='" + customerFirstName + '\'' +
                ", phone='" + phone + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", postalCode='" + postalCode + '\'' +
                ", country='" + country + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
