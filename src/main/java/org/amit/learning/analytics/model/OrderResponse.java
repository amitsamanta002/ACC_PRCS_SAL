package org.amit.learning.analytics.model;


import org.springframework.stereotype.Component;

@Component
public class OrderResponse {

    private int responseCode,responseStatusCode;
    private String responseMessage,responseComments;


    public OrderResponse() {
        this.responseCode = 00;
        this.responseStatusCode = 00;
        this.responseMessage = "";
        this.responseComments = "";
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public int getResponseStatusCode() {
        return responseStatusCode;
    }

    public void setResponseStatusCode(int responseStatusCode) {
        this.responseStatusCode = responseStatusCode;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    public void setResponseMessage(String responseMessage) {
        this.responseMessage = responseMessage;
    }

    public String getResponseComments() {
        return responseComments;
    }

    public void setResponseComments(String responseComments) {
        this.responseComments = responseComments;
    }


    @Override
    public String toString() {
        return "OrderResponse{" +
                "responseCode=" + responseCode +
                ", responseStatusCode=" + responseStatusCode +
                ", responseMessage='" + responseMessage + '\'' +
                ", responseComments='" + responseComments + '\'' +
                '}';
    }
}
