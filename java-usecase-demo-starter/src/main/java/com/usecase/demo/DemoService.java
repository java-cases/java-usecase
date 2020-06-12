package com.usecase.demo;

public class DemoService {

    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public DemoService(String message) {

        this.message = message;
    }

}
