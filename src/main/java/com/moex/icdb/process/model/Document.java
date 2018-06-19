package com.moex.icdb.process.model;

import org.springframework.http.HttpStatus;

public class Document {

    private int id;
    private String type;
    private String status;
    private HttpStatus httpStatus;
    private boolean notifiedType;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    public void setHttpStatus(HttpStatus httpStatus) {
        this.httpStatus = httpStatus;
    }

    public boolean isNotifiedType() {
        return notifiedType;
    }

    public void setNotifiedType(boolean notifiedType) {
        this.notifiedType = notifiedType;
    }
}