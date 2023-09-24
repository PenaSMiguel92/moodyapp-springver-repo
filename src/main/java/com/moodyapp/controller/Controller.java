package com.moodyapp.controller;

import com.moodyapp.entity.Account;
import com.moodyapp.entity.UserInfo;
import com.moodyapp.exceptions.InvalidCredentialsException;
import com.moodyapp.service.AccountService;
import com.moodyapp.service.UserInfoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    AccountService accountService;
    UserInfoService userInfoService;
    @Autowired
    public Controller(AccountService accountService, UserInfoService userInfoService) {
        this.accountService = accountService;
        this.userInfoService = userInfoService;
    }


    @GetMapping("/accounts")
    public List<Account> getExistingAccounts() {
        return this.accountService.getAllAccounts();
    }

    @PostMapping("/accounts")
    public Account registerAccount(@RequestBody Account account) throws InvalidCredentialsException {
        Optional<Account> accountOptional = Optional.of(this.accountService.registerAccount(account));
        if (accountOptional.isPresent())
            return accountOptional.get();

        return null;
    }

}
