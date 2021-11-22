package com.devweek.camundademo.bankaccount.dto;

import com.devweek.camundademo.bankaccount.model.*;
import lombok.*;

import javax.validation.constraints.*;
import java.util.*;

import static com.devweek.camundademo.common.util.ValidationPatterns.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateBankAccountRequest {
    @NotBlank
    @Pattern(regexp = NUMERIC)
    private String merchantId;

    @NotNull
    private Boolean merchantOwned;

    @NotNull
    private Set<BankAccountUsage> usages;

    @NotNull
    @Size(min = 6, max = 6)
    @Pattern(regexp = NUMERIC)
    private String sortCode;

    @NotNull
    @Size(min = 8, max = 8)
    @Pattern(regexp = NUMERIC)
    private String accountNumber;

}
