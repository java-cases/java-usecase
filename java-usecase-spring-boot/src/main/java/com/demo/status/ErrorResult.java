package com.demo.status;

public class ErrorResult {

    private String status;
    private ErrorMessage error;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ErrorMessage getError() {
        return error;
    }

    public void setError(ErrorMessage error) {
        this.error = error;
    }

    public ErrorResult(){

    }

    public ErrorResult(String status, String code, String message) {
        this.status = status;
        this.error = new ErrorMessage(code, message);
    }
}
