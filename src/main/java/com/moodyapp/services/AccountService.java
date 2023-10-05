package com.moodyapp.services;
import com.moodyapp.entities.Account;
import com.moodyapp.exceptions.ClientErrorException;
import com.moodyapp.exceptions.ConflictException;
import com.moodyapp.exceptions.UnauthorizedException;
import com.moodyapp.repositories.AccountRepository;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Transactional
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

    public Account registerAccount(Account account) throws ClientErrorException, ConflictException {
        if (account.getUsername().isEmpty())
            throw new ClientErrorException("Username is empty, please enter a valid username.");
        if (account.getPass().length() < 4)
            throw new ClientErrorException("Password is too short, please choose a longer password.");

        Optional<Account> accountOptional = Optional
                .ofNullable(this.accountRepository.findByUsername(account.getUsername()));
        if (accountOptional.isPresent())
            throw new ConflictException("Username already exists, please choose another.");
        account.generateMoodlets();
        return this.accountRepository.save(account);
    }
    
    public Account loginRequest(Account account) throws ClientErrorException, UnauthorizedException {
        if (account.getUsername().isEmpty())
            throw new ClientErrorException("Username is empty, please enter a valid username.");
        Optional<Account> accountOptional = Optional
                .ofNullable(this.accountRepository.findByUsername(account.getUsername()));
        if (!accountOptional.isPresent())
            throw new ClientErrorException("Username does not exist, please enter a valid username.");
        Account existingAccount = accountOptional.get();
        if (!existingAccount.getPass().equals(account.getPass()))
            throw new UnauthorizedException("Passwords do not match, please enter valid password.");
        
        return existingAccount; 
    }


}
