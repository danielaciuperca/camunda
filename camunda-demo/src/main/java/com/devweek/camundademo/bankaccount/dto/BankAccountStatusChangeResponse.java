package com.devweek.camundademo.bankaccount.dto;

import com.devweek.camundademo.bankaccount.model.*;
import lombok.*;

import java.time.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountStatusChangeResponse {

    private String bankAccountId;

    private BankAccountStatus newStatus;

    private BankAccountStatus oldStatus;

    private String reason;

    private LocalDateTime changedAt;
}

