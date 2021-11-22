package com.devweek.camundademo.bankaccount.changebankaccountstatus.task;

import com.devweek.camundademo.bankaccount.changebankaccountstatus.*;
import com.devweek.camundademo.common.exception.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.camunda.bpm.engine.delegate.*;
import org.springframework.stereotype.*;

import static com.devweek.camundademo.bankaccount.changebankaccountstatus.Flow.*;


@Service
@Slf4j
@AllArgsConstructor
public class CheckMerchantOwnedTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        ChangeBankAccountStatusFlowContextData input =
                (ChangeBankAccountStatusFlowContextData) execution.getVariable(FLOW_CONTEXT_DATA);
        if (!input.getBankAccount().getMerchantOwned()) {
            throw new BusinessException(ErrorCodes.BANK_ACCOUNT_STATUS_CHANGE_NOT_OWNED);
        }
    }
}
