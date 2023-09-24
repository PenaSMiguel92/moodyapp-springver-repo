package com.moodyapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.moodyapp.entity.UserInfo;

public interface UserInfoRepository extends JpaRepository<UserInfo, Long> {
    
}
