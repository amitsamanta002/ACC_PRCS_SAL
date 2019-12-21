package org.amit.learning.analytics.model;

import org.springframework.stereotype.Component;

@Component
public class TestResponse {

    private String name,address;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public TestResponse() {
    }
}
