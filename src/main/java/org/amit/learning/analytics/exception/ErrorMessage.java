package org.amit.learning.analytics.exception;

public class ErrorMessage {

    private int errCode,errStatus;
    private String errMessage,errDescription;

    public ErrorMessage() {
    }

    @Override
    public String toString() {
        return "ErrorMessage{" +
                "errCode=" + errCode +
                ", errStatus=" + errStatus +
                ", errMessage='" + errMessage + '\'' +
                ", errDescription='" + errDescription + '\'' +
                '}';
    }

    public int getErrCode() {
        return errCode;
    }

    public void setErrCode(int errCode) {
        this.errCode = errCode;
    }

    public int getErrStatus() {
        return errStatus;
    }

    public void setErrStatus(int errStatus) {
        this.errStatus = errStatus;
    }

    public String getErrMessage() {
        return errMessage;
    }

    public void setErrMessage(String errMessage) {
        this.errMessage = errMessage;
    }

    public String getErrDescription() {
        return errDescription;
    }

    public void setErrDescription(String errDescription) {
        this.errDescription = errDescription;
    }
}
