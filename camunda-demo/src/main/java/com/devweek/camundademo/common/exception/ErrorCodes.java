package com.devweek.camundademo.common.exception;

import lombok.*;

@Getter
public enum ErrorCodes {
    MERCHANT_NOT_MATCH("The merchant does not match the payload."),
    BANK_ACCOUNT_NOT_FOUND("The bank account was not found."),

    BANK_ACCOUNT_STATUS_CHANGE_TRANSITION("Current bank account status cannot be followed by the requested status."),
    BANK_ACCOUNT_STATUS_CHANGE_NOT_OWNED("Bank account status change can not be changed if merchant owned is false.");

    private final String message;

    ErrorCodes(String message) {
        this.message = message;
    }
}
