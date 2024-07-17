package com.hilaryd.blog.services;

import com.hilaryd.blog.dto.RegistrationDto;
import com.hilaryd.blog.entity.User;

import java.util.Optional;

public interface RegistrationService {
    void registerUser(RegistrationDto registrationDto);

    Optional<User> findByEmail(String email);

}
