package com.moodyapp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodyapp.entities.Profile;
import com.moodyapp.repositories.ProfileRepository;

@Service
public class ProfileService {
    ProfileRepository profileRepository;
    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile registerUserInformation(Profile profile) {
        return this.profileRepository.save(profile);
    }
}
