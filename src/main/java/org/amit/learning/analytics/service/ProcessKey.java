package org.amit.learning.analytics.service;


public class ProcessKey {

    private String keyCity,keyState,keyPostalCode,keyCountry;

    public ProcessKey() {
        this.keyCity = "";
        this.keyState = "";
        this.keyPostalCode = "";
        this.keyCountry = "";
    }

    public String getKeyCity() {
        return keyCity;
    }

    public void setKeyCity(String keyCity) {
        this.keyCity = keyCity;
    }

    public String getKeyState() {
        return keyState;
    }

    public void setKeyState(String keyState) {
        this.keyState = keyState;
    }

    public String getKeyPostalCode() {
        return keyPostalCode;
    }

    public void setKeyPostalCode(String keyPostalCode) {
        this.keyPostalCode = keyPostalCode;
    }

    public String getKeyCountry() {
        return keyCountry;
    }

    public void setKeyCountry(String keyCountry) {
        this.keyCountry = keyCountry;
    }
}
