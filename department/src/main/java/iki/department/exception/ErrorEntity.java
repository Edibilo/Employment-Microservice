package iki.department.exception;

import java.time.LocalDateTime;


public class ErrorEntity {
    private String errorCode;
    private String message;
    private LocalDateTime localDateTime;

    public ErrorEntity(){

    }

    public ErrorEntity(String errorCode, String message, LocalDateTime localDateTime) {
        this.errorCode = errorCode;
        this.message = message;
        this.localDateTime = localDateTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }
}
