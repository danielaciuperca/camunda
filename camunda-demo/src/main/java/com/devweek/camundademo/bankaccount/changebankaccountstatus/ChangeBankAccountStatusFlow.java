package com.devweek.camundademo.bankaccount.changebankaccountstatus;

import org.camunda.bpm.engine.*;
import org.springframework.stereotype.*;

import static com.devweek.camundademo.bankaccount.changebankaccountstatus.FlowName.*;

@Service
public class ChangeBankAccountStatusFlow extends Flow<ChangeBankAccountStatusFlowContextData> {

    @Override
    public FlowName getFlowName() {
        return CHANGE_BANK_ACCOUNT_STATUS;
    }

    public ChangeBankAccountStatusFlow(RuntimeService runtimeService) {
        super(runtimeService, ChangeBankAccountStatusFlowContextData.class);
    }
}
