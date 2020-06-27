package com.zhukovsd.alfabattle.task2.analytics;

public class ErrorJsonResponse {

    private String status;

    public ErrorJsonResponse() {
    }

    public ErrorJsonResponse(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
