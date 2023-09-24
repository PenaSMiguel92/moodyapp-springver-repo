package com.moodyapp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moodyapp.entity.UserInfo;
import com.moodyapp.repository.UserInfoRepository;

@Service
public class UserInfoService {
    UserInfoRepository userInfoRepository;
    @Autowired
    public UserInfoService(UserInfoRepository userInfoRepository) {
        this.userInfoRepository = userInfoRepository;
    }

    public UserInfo registerUserInformation(UserInfo userinfo) {
        return this.userInfoRepository.save(userinfo);
    }
}
