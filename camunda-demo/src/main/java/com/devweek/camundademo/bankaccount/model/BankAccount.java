package com.devweek.camundademo.bankaccount.model;

import lombok.*;
import org.springframework.data.annotation.*;
import org.springframework.data.mongodb.core.mapping.*;

import javax.validation.constraints.*;
import java.io.*;
import java.util.*;

import static com.devweek.camundademo.common.util.ValidationPatterns.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "bankAccounts")
public class BankAccount implements Serializable {

    @Id
    private String key;

    @NotNull
    private BankAccountStatus status;

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

    private List<BankAccountStatusChange> statusHistory;
}
