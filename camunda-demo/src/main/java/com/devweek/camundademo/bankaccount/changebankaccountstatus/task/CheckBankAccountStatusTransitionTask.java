package com.devweek.camundademo.bankaccount.changebankaccountstatus.task;

import com.devweek.camundademo.bankaccount.changebankaccountstatus.*;
import com.devweek.camundademo.bankaccount.model.*;
import com.devweek.camundademo.common.exception.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.camunda.bpm.engine.delegate.*;
import org.springframework.stereotype.*;

import static com.devweek.camundademo.bankaccount.changebankaccountstatus.Flow.*;
import static com.devweek.camundademo.common.exception.ErrorCodes.*;


@Service
@Slf4j
@AllArgsConstructor
public class CheckBankAccountStatusTransitionTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        ChangeBankAccountStatusFlowContextData input =
                (ChangeBankAccountStatusFlowContextData) execution.getVariable(FLOW_CONTEXT_DATA);
        BankAccountStatus newStatus = input.getBankAccountStatusChange().getNewStatus();
        BankAccountStatus oldStatus = input.getBankAccount().getStatus();
        if (!newStatus.canHavePrevious(oldStatus)) {
            throw new BusinessException(BANK_ACCOUNT_STATUS_CHANGE_TRANSITION);
        }
    }
}
