package com.devweek.camundademo.bankaccount.changebankaccountstatus;

import lombok.*;

@AllArgsConstructor
@Getter
public enum FlowName {

    CHANGE_BANK_ACCOUNT_STATUS("changeBankAccountStatusFlow");

    private String flowId;
}
