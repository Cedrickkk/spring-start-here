package org.spring.framework.sqch13ex2.services;


import org.spring.framework.sqch13ex2.models.Account;
import org.spring.framework.sqch13ex2.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
public class TransferService {
    private final org.spring.framework.sqch13ex2.repositories.AccountRepository accountRepository;

    @Autowired
    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void transferMoney(long senderId, long receiverId, BigDecimal amount) {
        Account sender = accountRepository.findAccountById(senderId);
        Account receiver = accountRepository.findAccountById(receiverId);
        accountRepository.changeAmount(senderId, sender.getAmount().subtract(amount));
        accountRepository.changeAmount(receiverId, receiver.getAmount().add(amount));
        throw new RuntimeException("Test"); // simulate a runtime exception
    }
}
