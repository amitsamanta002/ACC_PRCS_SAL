package org.amit.learning.analytics.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.io.IOException;

@ControllerAdvice
public class DefaultExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> rootExceptionforAll(Exception ex){

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrCode(999);
        errorMessage.setErrMessage(ex.getMessage());
        errorMessage.setErrDescription("Exception occurs at Root");
        errorMessage.setErrStatus(9999);
        return new ResponseEntity <ErrorMessage>(errorMessage,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<ErrorMessage> IOExceptionforAll(Exception ex){

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrCode(888);
        errorMessage.setErrMessage(ex.getMessage());
        errorMessage.setErrDescription("Exception occurs at Data null");
        errorMessage.setErrStatus(888);
        return new ResponseEntity <ErrorMessage>(errorMessage,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArrayIndexOutOfBoundsException.class)
    public ResponseEntity<ErrorMessage> ArrayOutofBoundforAll(Exception ex){

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrCode(777);
        errorMessage.setErrMessage(ex.getMessage());
        errorMessage.setErrDescription("Exception occurs while Array Data populate");
        errorMessage.setErrStatus(777);
        return new ResponseEntity <ErrorMessage>(errorMessage,new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(BadDataInput.class)
    public ResponseEntity<ErrorMessage> badDataInputExceptionforAll(Exception ex){

        ErrorMessage errorMessage = new ErrorMessage();
        errorMessage.setErrCode(666);
        errorMessage.setErrMessage(ex.getMessage());
        errorMessage.setErrDescription("Data came to service is bad.");
        errorMessage.setErrStatus(666);
        return new ResponseEntity <ErrorMessage>(errorMessage,new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
