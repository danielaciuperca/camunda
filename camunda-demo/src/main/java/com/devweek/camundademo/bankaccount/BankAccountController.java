package com.devweek.camundademo.bankaccount;


import com.devweek.camundademo.bankaccount.dto.*;
import com.devweek.camundademo.bankaccount.model.*;
import lombok.*;
import lombok.extern.slf4j.*;
import org.springframework.http.*;
import org.springframework.validation.annotation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import javax.validation.constraints.*;

import static com.devweek.camundademo.common.util.ValidationPatterns.*;
import static org.springframework.http.HttpStatus.*;

@RestController
@RequestMapping("/bankAccounts")
@AllArgsConstructor
@Slf4j
@Validated
public class BankAccountController {

    private final BankAccountService bankAccountService;
    private final BankAccountMapper bankAccountMapper;

    @PostMapping
    public ResponseEntity<BankAccountResponse> createBankAccount(
            @Valid
            @RequestBody
                    CreateBankAccountRequest bankAccountRequest) {
        BankAccount bankAccount = bankAccountMapper.createBankAccountRequestToBankAccount(bankAccountRequest);
        BankAccount createdBankAccount = bankAccountService.create(bankAccount);
        BankAccountResponse response = bankAccountMapper.bankAccountToBankAccountResponse(createdBankAccount);
        return ResponseEntity.created(null)
                .body(response);
    }


    @PostMapping("/{bankAccountId}/statusChanges")
    @ResponseStatus(CREATED)
    public ResponseEntity<BankAccountStatusChangeResponse> updateBankAccountStatus(
            @Size(min = 36, max = 36)
            @Pattern(regexp = UUID)
            @PathVariable(name = "bankAccountId")
                    String bankAccountId,
            @Valid
            @RequestBody BankAccountStatusChangeRequest request) {

        BankAccountStatusChange bankAccountStatusChange =
                bankAccountMapper.bankAccountStatusChangeRequestToBankAccountStatusChange(request);
        BankAccountStatusChange statusChange = bankAccountService.changeBankAccountStatus(bankAccountStatusChange);
        BankAccountStatusChangeResponse statusChangeResponse =
                bankAccountMapper.bankAccountStatusChangeToBankAccountStatusChangeResponse(statusChange);
        return ResponseEntity.created(null)
                .body(statusChangeResponse);
    }
}