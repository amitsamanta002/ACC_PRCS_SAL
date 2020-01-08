package org.amit.learning.analytics.exception;

import java.util.PrimitiveIterator;

public class BadDataInput extends Exception {

    private String message;
    private int code;

    public BadDataInput(String message){
        super(message);
    }
}
