package com.devweek.camundademo.bankaccount.dto;

import com.devweek.camundademo.bankaccount.model.*;
import lombok.*;

import javax.validation.constraints.*;

import static com.devweek.camundademo.common.util.ValidationPatterns.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BankAccountStatusChangeRequest {
    @NotNull
    @Size(min = 36, max = 36)
    @Pattern(regexp = UUID)
    private String bankAccountId;

    @NotNull
    private BankAccountStatus newStatus;

    @Size(max = 140)
    @NotBlank
    private String reason;
}

