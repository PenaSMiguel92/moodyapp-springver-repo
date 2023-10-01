package com.moodyapp.services;
import com.moodyapp.entities.Account;
import com.moodyapp.exceptions.InvalidCredentialsException;
import com.moodyapp.repositories.AccountRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional(rollbackOn = InvalidCredentialsException.class)
@Service
public class AccountService {
    AccountRepository accountRepository;
    @Autowired
    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    public Account registerAccount(Account account) throws InvalidCredentialsException {
        if (account.getUsername().isEmpty())
            throw new InvalidCredentialsException("Username is empty, please enter a valid username.");
        if (account.getPass().length() < 4)
            throw new InvalidCredentialsException("Password is too short, please choose a longer password.");
            
        Optional<Account> accountOptional = Optional.ofNullable(this.accountRepository.findByUsername(account.getUsername()));
        if (accountOptional.isPresent())
            throw new InvalidCredentialsException("Username already exists, please choose another.");
        
        return this.accountRepository.save(account);
    }


}
