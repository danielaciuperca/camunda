package com.devweek.camundademo.bankaccount.changebankaccountstatus;

import com.devweek.camundademo.bankaccount.model.*;
import lombok.*;
import org.camunda.bpm.engine.runtime.*;

import java.util.*;

@Data
@NoArgsConstructor
public class ChangeBankAccountStatusFlowContextData extends FlowContextData {

    private BankAccountStatusChange bankAccountStatusChange;
    private BankAccount bankAccount;
    private List<String> failedChecks;

    @Builder
    public ChangeBankAccountStatusFlowContextData(ProcessInstanceWithVariables processInstanceWithVariables, BankAccountStatusChange bankAccountStatusChange, BankAccount bankAccount, List<String> failedChecks) {
        super(processInstanceWithVariables);
        this.bankAccountStatusChange = bankAccountStatusChange;
        this.bankAccount = bankAccount;
        this.failedChecks = failedChecks;
    }
}
