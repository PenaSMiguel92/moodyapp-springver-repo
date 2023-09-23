package com.moodyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodyapp.entity.Account;

public interface AccountDAI extends JpaRepository<Account, Long> {
    
}
