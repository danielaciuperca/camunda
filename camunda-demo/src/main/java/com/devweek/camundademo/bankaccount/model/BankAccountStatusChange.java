package com.devweek.camundademo.bankaccount.model;

import lombok.*;

import java.io.*;
import java.time.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountStatusChange implements Serializable {
    private String bankAccountId;
    private BankAccountStatus oldStatus;
    private BankAccountStatus newStatus;
    private String reason;
    private LocalDateTime changedAt;
}
