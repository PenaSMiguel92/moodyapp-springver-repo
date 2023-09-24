package com.moodyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodyapp.entity.Moodlet;

public interface MoodletRepository extends JpaRepository<Moodlet, Long> {
    
}