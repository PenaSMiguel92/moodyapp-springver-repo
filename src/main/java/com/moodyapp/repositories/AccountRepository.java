package com.moodyapp.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moodyapp.entities.Account;

import jakarta.transaction.Transactional;

@Transactional
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("FROM Account WHERE username = :usernameVar")
    public Account findByUsername(@Param("usernameVar") String username);
}
