package com.moodyapp.controllers;

import com.moodyapp.entities.Account;
import com.moodyapp.entities.Moodlet;
import com.moodyapp.entities.Profile;
import com.moodyapp.exceptions.ClientErrorException;
import com.moodyapp.exceptions.ConflictException;
import com.moodyapp.exceptions.UnauthorizedException;
import com.moodyapp.services.AccountService;
import com.moodyapp.services.MoodletService;
import com.moodyapp.services.ProfileService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    AccountService accountService;
    MoodletService moodletService;
    ProfileService profileService;
    @Autowired
    public Controller(AccountService accountService, ProfileService profileService, MoodletService moodletService) {
        this.accountService = accountService;
        this.profileService = profileService;
        this.moodletService = moodletService;
    }


    @GetMapping("/accounts")
    @ResponseStatus(HttpStatus.OK)
    public List<Account> getExistingAccounts() {
        return this.accountService.getAllAccounts();
    }

    @PostMapping("/register")
    @ResponseStatus(HttpStatus.OK)
    public Account registerAccount(@RequestBody Account account) throws ClientErrorException, ConflictException {
        Optional<Account> accountOptional = Optional.of(this.accountService.registerAccount(account));
        if (!accountOptional.isPresent())
            throw new ClientErrorException("Account was not successfully created.");

        return accountOptional.get();
    }

    @GetMapping("/login")
    @ResponseStatus(HttpStatus.OK)
    public Account loginRequest(@RequestBody Account account) throws ClientErrorException, UnauthorizedException {
        Optional<Account> accountOptional = Optional.ofNullable(this.accountService.loginRequest(account));
        if (!accountOptional.isPresent())
            throw new ClientErrorException("Please enter valid credentials.");

        return accountOptional.get();
    }
    
    @PostMapping("/accounts/{username}/profile")
    @ResponseStatus(HttpStatus.OK)
    public Profile registerProfileHandler(@PathVariable("username") String username, @RequestBody Profile profile)
            throws ClientErrorException, ConflictException {
        profile.setOwned_by(username);
        return this.profileService.registerProfile(profile);
    }

    // @GetMapping("/accounts/{username}/profile")
    // @ResponseStatus(HttpStatus.OK)
    // public Profile getProfileHandler(@PathVariable("username") String username) throws ClientErrorException {
    //     return this.profileService.retrieveProfileByUsername(username);
    //}

    @ExceptionHandler(ConflictException.class)
    @ResponseStatus(HttpStatus.CONFLICT)
    public String handleConflictException(ConflictException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(ClientErrorException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public String handleClientErrorException(ClientErrorException ex) {
        return ex.getMessage();
    }

    @ExceptionHandler(UnauthorizedException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public String handleUnauthorizedException(UnauthorizedException ex) {
        return ex.getMessage();
    }




}
