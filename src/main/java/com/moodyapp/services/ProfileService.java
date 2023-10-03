package com.moodyapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodyapp.entities.Profile;
import com.moodyapp.exceptions.ClientErrorException;
import com.moodyapp.exceptions.ConflictException;
import com.moodyapp.repositories.ProfileRepository;

@Service
public class ProfileService {
    ProfileRepository profileRepository;
    @Autowired
    public ProfileService(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    public Profile registerProfile(Profile profile) throws ClientErrorException, ConflictException {
        if (profile.getFirst_name().isBlank() || profile.getLast_name().isBlank())
            throw new ClientErrorException("One or both names are empty. Please enter valid names.");
        Optional<Profile> profileOptional = Optional
                .ofNullable(this.profileRepository.findProfileByOwnership(profile.getOwned_by()));
        if (profileOptional.isPresent())
            throw new ConflictException("User profile already exists.");
            
        return this.profileRepository.save(profile);
    }
}
