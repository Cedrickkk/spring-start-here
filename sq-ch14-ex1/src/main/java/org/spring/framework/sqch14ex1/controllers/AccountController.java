package org.spring.framework.sqch14ex1.controllers;

import org.spring.framework.sqch14ex1.models.Account;
import org.spring.framework.sqch14ex1.models.SuccessResponse;
import org.spring.framework.sqch14ex1.models.TransferRequest;
import org.spring.framework.sqch14ex1.services.AccountService;
import org.spring.framework.sqch14ex1.services.TransferService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {
    private final TransferService transferService;
    private final AccountService accountService;

    @Autowired
    public AccountController(TransferService transferService, AccountService accountService) {
        this.transferService = transferService;
        this.accountService = accountService;
    }

    @PostMapping("/transfer")
    public ResponseEntity<SuccessResponse<Account>> transfer(@RequestBody TransferRequest request) {
        transferService.transferMoney(
                request.getFromAccountId(),
                request.getToAccountId(),
                request.getAmount()
        );
        SuccessResponse<Account> response = new SuccessResponse<>(HttpStatus.OK, "Transferred successfully",
                accountService.findAccountById(
                        request.getFromAccountId()));
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/accounts")
    public ResponseEntity<SuccessResponse<List<Account>>> getAllAccounts() {
        List<Account> accountList = accountService.findAllAccounts();
        SuccessResponse<List<Account>> response =
                new SuccessResponse<>(HttpStatus.OK, "Accounts found", accountList);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping("/accounts/{id}")
    public ResponseEntity<SuccessResponse<Account>> getAccountById(@PathVariable long id) {
        Account account = accountService.findAccountById(id);
        SuccessResponse<Account> response = new SuccessResponse<>(HttpStatus.FOUND, "Account found", account);
        return new ResponseEntity<>(response, HttpStatus.FOUND);
    }
}
