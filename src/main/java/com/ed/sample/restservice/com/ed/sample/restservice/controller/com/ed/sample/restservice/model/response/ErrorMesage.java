package com.ed.sample.restservice.com.ed.sample.restservice.controller.com.ed.sample.restservice.model.response;

import java.util.Date;

public class ErrorMesage {

    private Date timestamp;
    private String message;

    public ErrorMesage(){}

    public ErrorMesage(Date timestamp, String message){
        this.timestamp = timestamp;
        this.message = message;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Date timestamp) {
        this.timestamp = timestamp;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
