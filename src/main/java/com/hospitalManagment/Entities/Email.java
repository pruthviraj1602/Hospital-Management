package com.hospitalManagment.Entities;

import lombok.Data;

@Data
public class Email {
    private String to;
    private String message;
    private String subject;
    private String[] tos;

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String[] getTos() {
        return tos;
    }

    public void setTos(String[] tos) {
        this.tos = tos;
    }
}
