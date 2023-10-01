package com.moodyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodyapp.entities.Profile;

public interface ProfileRepository extends JpaRepository<Profile, Long> {
    
}
