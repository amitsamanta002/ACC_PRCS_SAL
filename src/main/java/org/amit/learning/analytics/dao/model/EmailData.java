package org.amit.learning.analytics.dao.model;

import org.springframework.stereotype.Component;

@Component
public class EmailData {

    private String emailTo,emailCC,emailSubject,emailTextBody;
    private String toaddFname,toaddLname;

    public EmailData() {
    }

    public String getToaddFname() {
        return toaddFname;
    }

    public void setToaddFname(String toaddFname) {
        this.toaddFname = toaddFname;
    }

    public String getToaddLname() {
        return toaddLname;
    }

    public void setToaddLname(String toaddLname) {
        this.toaddLname = toaddLname;
    }

    public String getEmailTo() {
        return emailTo;
    }

    public void setEmailTo(String emailTo) {
        this.emailTo = emailTo;
    }

    public String getEmailCC() {
        return emailCC;
    }

    public void setEmailCC(String emailCC) {
        this.emailCC = emailCC;
    }

    public String getEmailSubject() {
        return emailSubject;
    }

    public void setEmailSubject(String emailSubject) {
        this.emailSubject = emailSubject;
    }

    public String getEmailTextBody() {
        return emailTextBody;
    }

    public void setEmailTextBody(String emailTextBody) {
        this.emailTextBody = emailTextBody;
    }

    @Override
    public String toString() {
        return "EmailData{" +
                "emailTo='" + emailTo + '\'' +
                ", emailCC='" + emailCC + '\'' +
                ", emailSubject='" + emailSubject + '\'' +
                ", emailTextBody='" + emailTextBody + '\'' +
                ", toaddFname='" + toaddFname + '\'' +
                ", toaddLname='" + toaddLname + '\'' +
                '}';
    }
}
