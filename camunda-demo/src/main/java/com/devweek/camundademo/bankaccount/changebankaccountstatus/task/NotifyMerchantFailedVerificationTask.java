package com.devweek.camundademo.bankaccount.changebankaccountstatus.task;

import com.devweek.camundademo.bankaccount.changebankaccountstatus.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.camunda.bpm.engine.delegate.*;
import org.springframework.stereotype.*;

import static com.devweek.camundademo.bankaccount.changebankaccountstatus.Flow.*;

@Service
@Slf4j
@AllArgsConstructor
public class NotifyMerchantFailedVerificationTask implements JavaDelegate {

    @Override
    public void execute(DelegateExecution execution) {
        ChangeBankAccountStatusFlowContextData input =
                (ChangeBankAccountStatusFlowContextData) execution.getVariable(FLOW_CONTEXT_DATA);
        String merchantId = input.getBankAccount().getMerchantId();

        //notify merchant with id = merchantId that the bank account has failed the verification
    }
}