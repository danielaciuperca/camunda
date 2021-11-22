package com.devweek.camundademo.bankaccount.model;

import java.util.*;

public enum BankAccountStatus {
    UNVERIFIED,
    FAILED_VERIFICATION(UNVERIFIED),
    VERIFIED(UNVERIFIED),
    BANK_ACCOUNT_CLOSED(VERIFIED, UNVERIFIED);

    private List<BankAccountStatus> previousPossibleStatuses;

    BankAccountStatus(BankAccountStatus... args) {
        if (args == null) {
            this.previousPossibleStatuses = List.of();
        } else {
            this.previousPossibleStatuses = List.of(args);
        }
    }

    public boolean canHavePrevious(BankAccountStatus oldStatus) {
        return previousPossibleStatuses.contains(oldStatus);
    }

}
