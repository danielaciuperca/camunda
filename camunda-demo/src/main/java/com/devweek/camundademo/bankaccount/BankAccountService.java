package com.devweek.camundademo.bankaccount;

import com.devweek.camundademo.bankaccount.changebankaccountstatus.*;
import com.devweek.camundademo.bankaccount.model.*;
import com.devweek.camundademo.common.exception.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.stereotype.*;

import static com.devweek.camundademo.common.exception.ErrorCodes.*;

@Service
@Slf4j
@AllArgsConstructor
public class BankAccountService {
	private final BankAccountRepository bankAccountRepository;
	private final ChangeBankAccountStatusFlow changeBankAccountStatusFlow;

	public BankAccount create(BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount);
	}

	public BankAccountStatusChange changeBankAccountStatus(BankAccountStatusChange bankAccountStatusChange) {
		BankAccount bankAccount = findBy(bankAccountStatusChange.getBankAccountId());
		ChangeBankAccountStatusFlowContextData result = changeBankAccountStatusFlow.runFlow(ChangeBankAccountStatusFlowContextData
				.builder()
				.bankAccount(bankAccount)
				.bankAccountStatusChange(bankAccountStatusChange)
				.build());
		return result.getBankAccountStatusChange();
	}

	public BankAccount findBy(String key) {
		return bankAccountRepository.findById(key).orElseThrow(() -> new BusinessException(BANK_ACCOUNT_NOT_FOUND));
	}

	public BankAccount save(BankAccount bankAccount) {
		return bankAccountRepository.save(bankAccount);
	}
}