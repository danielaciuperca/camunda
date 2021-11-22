package com.devweek.camundademo.bankaccount;

import com.devweek.camundademo.bankaccount.dto.*;
import com.devweek.camundademo.bankaccount.model.*;
import org.springframework.stereotype.*;

import java.time.*;
import java.util.*;

@Component
public class BankAccountMapper {

    public BankAccount createBankAccountRequestToBankAccount(CreateBankAccountRequest bankAccountRequest) {
        return new BankAccount(UUID.randomUUID().toString(),
                BankAccountStatus.UNVERIFIED,
                bankAccountRequest.getMerchantId(),
                bankAccountRequest.getMerchantOwned(),
                bankAccountRequest.getUsages(),
                bankAccountRequest.getSortCode(),
                bankAccountRequest.getAccountNumber(),
                new ArrayList<>());
    }

    public BankAccountResponse bankAccountToBankAccountResponse(BankAccount bankAccount) {
        return new BankAccountResponse(bankAccount.getKey(),
                bankAccount.getStatus(),
                bankAccount.getMerchantId(),
                bankAccount.getMerchantOwned(),
                bankAccount.getUsages(),
                bankAccount.getSortCode(),
                bankAccount.getAccountNumber(),
                bankAccount.getStatusHistory());
    }

    public BankAccountStatusChange bankAccountStatusChangeRequestToBankAccountStatusChange(BankAccountStatusChangeRequest bankAccountStatusChangeRequest) {
        return new BankAccountStatusChange(bankAccountStatusChangeRequest.getBankAccountId(),
                null,
                bankAccountStatusChangeRequest.getNewStatus(),
                bankAccountStatusChangeRequest.getReason(),
                LocalDateTime.now()
                );
    }

    public BankAccountStatusChangeResponse bankAccountStatusChangeToBankAccountStatusChangeResponse(BankAccountStatusChange bankAccountStatusChange) {
        return new BankAccountStatusChangeResponse(
                bankAccountStatusChange.getBankAccountId(),
                bankAccountStatusChange.getNewStatus(),
                bankAccountStatusChange.getOldStatus(),
                bankAccountStatusChange.getReason(),
                bankAccountStatusChange.getChangedAt());
    }
}
