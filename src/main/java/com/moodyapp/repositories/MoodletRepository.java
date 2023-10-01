package com.moodyapp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodyapp.entities.Moodlet;

public interface MoodletRepository extends JpaRepository<Moodlet, Long> {
    
}