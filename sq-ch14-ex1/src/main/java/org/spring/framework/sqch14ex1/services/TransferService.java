package org.spring.framework.sqch14ex1.services;

import org.spring.framework.sqch14ex1.exceptions.AccountNotFoundException;
import org.spring.framework.sqch14ex1.models.Account;
import org.spring.framework.sqch14ex1.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

@Service
@Transactional
public class TransferService {
    private final AccountRepository accountRepository;

    @Autowired
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transferMoney(long fromAccountId, long toAccountId, BigDecimal amount) {
        Account sender = accountRepository.findById(fromAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Account not found."));

        Account receiver = accountRepository.findById(toAccountId)
                .orElseThrow(() -> new AccountNotFoundException("Account receiver not found."));

        accountRepository.changeAmount(sender.getId(), sender.getAmount().subtract(amount));
        accountRepository.changeAmount(receiver.getId(), receiver.getAmount().add(amount));
    }
}
