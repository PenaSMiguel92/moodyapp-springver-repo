package com.moodyapp.controllers;

import com.moodyapp.entities.Account;
import com.moodyapp.entities.Profile;
import com.moodyapp.exceptions.InvalidCredentialsException;
import com.moodyapp.services.AccountService;
import com.moodyapp.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    AccountService accountService;
    ProfileService userInfoService;
    @Autowired
    public Controller(AccountService accountService, ProfileService userInfoService) {
        this.accountService = accountService;
        this.userInfoService = userInfoService;
    }


    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getExistingAccounts() {
        return this.accountService.getAllAccounts();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public Account registerAccount(@RequestBody Account account) throws InvalidCredentialsException {
        Optional<Account> accountOptional = Optional.of(this.accountService.registerAccount(account));
        if (accountOptional.isPresent())
            return accountOptional.get();

        return null;
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Account loginRequest(@RequestBody Account account) throws InvalidCredentialsException {

        return null;
    }

    @ExceptionHandler(InvalidCredentialsException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleInvalidCredentialsException(InvalidCredentialsException ex) {
        return ex.getMessage();
    }


}