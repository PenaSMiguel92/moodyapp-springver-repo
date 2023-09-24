package com.moodyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moodyapp.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query("SELECT username FROM Account WHERE username = :usernameVar")
    public boolean checkIfUsernameExists(@Param("usernameVar") String username);
}
