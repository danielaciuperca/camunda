package com.devweek.camundademo.bankaccount.changebankaccountstatus.task;

import com.devweek.camundademo.bankaccount.*;
import com.devweek.camundademo.bankaccount.changebankaccountstatus.*;
import com.devweek.camundademo.bankaccount.model.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.camunda.bpm.engine.delegate.*;
import org.springframework.stereotype.*;

import static com.devweek.camundademo.bankaccount.changebankaccountstatus.Flow.*;

@Service
@Slf4j
@AllArgsConstructor
public class SaveBankAccountStatusChangeTask implements JavaDelegate {

    private BankAccountService bankAccountService;

    @Override
    public void execute(DelegateExecution execution) {
        ChangeBankAccountStatusFlowContextData input =
                (ChangeBankAccountStatusFlowContextData) execution.getVariable(FLOW_CONTEXT_DATA);

        BankAccount bankAccount = input.getBankAccount();
        BankAccountStatusChange bankAccountStatusChange = input.getBankAccountStatusChange();

        bankAccountStatusChange.setOldStatus(bankAccount.getStatus());
        bankAccount.setStatus(bankAccountStatusChange.getNewStatus());
        bankAccount.getStatusHistory().add(bankAccountStatusChange);

        BankAccount updatedBankAccount = bankAccountService.save(bankAccount);
        input.setBankAccount(updatedBankAccount);
    }
}
