package com.devweek.camundademo.common.exception;

public class BusinessException extends RuntimeException {
    public BusinessException(ErrorCodes errorCode) {
        super(errorCode.getMessage());
    }
}
