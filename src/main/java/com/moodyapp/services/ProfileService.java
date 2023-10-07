package com.moodyapp.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodyapp.entities.Account;
import com.moodyapp.entities.Profile;
import com.moodyapp.exceptions.ClientErrorException;
import com.moodyapp.exceptions.ConflictException;
import com.moodyapp.repositories.AccountRepository;
import com.moodyapp.repositories.ProfileRepository;

@Service
public class ProfileService {
    ProfileRepository profileRepository;
    AccountRepository accountRepository;
    @Autowired
    public ProfileService(ProfileRepository profileRepository, AccountRepository accountRepository) {
        this.profileRepository = profileRepository;
        this.accountRepository = accountRepository;
    }

    public Profile registerProfile(Profile profile, String username) throws ClientErrorException, ConflictException {
        if (profile.getFirst_name().isBlank() || profile.getLast_name().isBlank())
            throw new ClientErrorException("One or both names are empty. Please enter valid names.");

        Optional<Account> accountOptional = Optional.ofNullable(this.accountRepository.findByUsername(username));
        if (!accountOptional.isPresent())
            throw new ClientErrorException("Username does not exist.");
        
        Account account = accountOptional.get();
        profile.setOwned_by(account);
        Optional<Profile> profileOptional = Optional.ofNullable(this.profileRepository.findByUsername(username));
        if (profileOptional.isPresent())
            throw new ConflictException("User profile already exists.");

        return this.profileRepository.save(profile);
    }

    public Profile retrieveProfileByUsername(String username) throws ClientErrorException {
        if (username.isBlank())
            throw new ClientErrorException("That username is blank.");
        Optional<Account> accountOptional = Optional.ofNullable(this.accountRepository.findByUsername(username));
        if (!accountOptional.isPresent())
            throw new ClientErrorException("That username does not exist.");
        
        Account account = accountOptional.get();
        Optional<Profile> profileOptional = Optional
                .ofNullable(account.getProfile());
        if (!profileOptional.isPresent())
            throw new ClientErrorException("The profile does not exist.");
        return profileOptional.get();
    }
}
