package com.usecase.lang.exception;

public class CustomizdException extends Exception {

    private ExceptionType exceptionType;

    public ExceptionType getExceptionType() {
        return exceptionType;
    }

    public void setExceptionType(ExceptionType exceptionType) {
        this.exceptionType = exceptionType;
    }

    public CustomizdException() {
        super();
    }

    public CustomizdException(String message) {
        super(message);
    }

    public CustomizdException(String message, ExceptionType exceptionType) {
        super(message);
        this.setExceptionType(exceptionType);
    }

    public CustomizdException(String message, Throwable cause) {
        super(message, cause);
    }

    public CustomizdException(String message, Throwable cause, ExceptionType exceptionType) {
        super(message, cause);
        this.setExceptionType(exceptionType);
    }

    @Override
    public String toString() {
        return "CustomizdException{" +
                "exceptionType='" + exceptionType + '\'' + ",message=" + this.getLocalizedMessage() +
                '}';
    }
}
