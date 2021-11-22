package com.devweek.camundademo.bankaccount;

import com.devweek.camundademo.bankaccount.model.*;
import org.springframework.data.mongodb.repository.*;
import org.springframework.stereotype.*;

@Repository
public interface BankAccountRepository extends MongoRepository<BankAccount, String> {

}
