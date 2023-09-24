package com.moodyapp.controller;

import com.moodyapp.entity.Account;
import com.moodyapp.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {
    AccountService accountService;
    @Autowired
    public Controller(AccountService accountService) {
        this.accountService = accountService;
    }


    @GetMapping("/accounts")
    public List<Account> getExistingAccounts() {
        return this.accountService.getAllAccounts();
    }

}
