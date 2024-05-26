package com.santander.springWeb.Handler;

import java.time.LocalDate;

public class ResponseError {

    private LocalDate timestamp = LocalDate.now();
    private String status = "error";
    private int statusCode = 400;
    private String error;

    public LocalDate getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDate timestamp) {
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
}



