package com.moodyapp.service;
import com.moodyapp.entity.Account;
import com.moodyapp.repository.AccountDAI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountService {
    AccountDAI accountDAI;
    @Autowired
    public AccountService(AccountDAI accountDAI) {
        this.accountDAI = accountDAI;
    }

    public List<Account> getAllAccounts() {
        return this.accountDAI.findAll();
    }

    
}
