package com.moodyapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodyapp.repositories.MoodletRepository;

@Service
public class MoodletService {
    MoodletRepository moodletRepository;
    @Autowired
    public MoodletService(MoodletRepository moodletRepository) {
        this.moodletRepository = moodletRepository;
    }

    
}
