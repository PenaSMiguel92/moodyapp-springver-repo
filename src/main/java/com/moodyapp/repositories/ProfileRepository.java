package com.moodyapp.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.moodyapp.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    @Query("FROM Profile WHERE owned_by = :username")
    public Profile findByUsername(@Param("username") String username); 
}
