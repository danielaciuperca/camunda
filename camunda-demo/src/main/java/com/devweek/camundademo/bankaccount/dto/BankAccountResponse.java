package com.devweek.camundademo.bankaccount.dto;

import com.devweek.camundademo.bankaccount.model.*;
import lombok.*;

import java.util.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountResponse {

    private String key;

    private BankAccountStatus status;

    private String merchantId;

    private Boolean merchantOwned;

    private Set<BankAccountUsage> usages;

    private String sortCode;

    private String accountNumber;

    private List<BankAccountStatusChange> statusHistory;
}
