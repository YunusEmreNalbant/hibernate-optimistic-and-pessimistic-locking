package com.yunusemrenalbant.locking;

import org.springframework.retry.annotation.Retryable;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/bank-accounts")
public class BankAccountController {

    private final BankAccountRepository bankAccountRepository;

    public BankAccountController(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    @PostMapping
    public void createBankAccount() {
        BankAccount bankAccount = new BankAccount();
        bankAccount.setBalance(0);
        bankAccountRepository.save(bankAccount);
    }

    @PostMapping("/deposit-with-optimistic-lock")
    @Transactional(isolation = Isolation.SERIALIZABLE)
    @Retryable()
    public Optional<BankAccount> deposit() {
        BankAccount bankAccount = bankAccountRepository.findById(1L).get();
        bankAccount.setBalance(bankAccount.getBalance() + 1);
        bankAccountRepository.save(bankAccount);

        return Optional.of(bankAccount);

    }

    @PostMapping("/deposit-with-pessimistic-lock")
    @Transactional
    public Optional<BankAccount> depositWithPessimisticLock() {
        BankAccount bankAccount = bankAccountRepository.findByIdWithPessimisticLock(1L).get();
        bankAccount.setBalance(bankAccount.getBalance() + 1);
        bankAccountRepository.save(bankAccount);

        return Optional.of(bankAccount);

    }
}
