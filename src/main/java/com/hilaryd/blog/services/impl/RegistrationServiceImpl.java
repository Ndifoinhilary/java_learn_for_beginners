package com.hilaryd.blog.services.impl;

import com.hilaryd.blog.dto.RegistrationDto;
import com.hilaryd.blog.entity.Role;
import com.hilaryd.blog.entity.User;
import com.hilaryd.blog.repository.RoleRepository;
import com.hilaryd.blog.repository.UserRespository;
import com.hilaryd.blog.services.RegistrationService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RegistrationServiceImpl implements RegistrationService {

    private final UserRespository userRespository;
    private final RoleRepository roleRepository;
    private final ModelMapper modelMapper;

    private  final BCryptPasswordEncoder bCryptPasswordEncoder;
    @Override
    public void registerUser(RegistrationDto registrationDto) {
        Role role = roleRepository.findByName("ROLE_USER").get();
        User user =User.builder()
                .userName(registrationDto.getUserName())
                .email(registrationDto.getEmail())
                .password(bCryptPasswordEncoder.encode(registrationDto.getPassword()))
                .roles(List.of(role))
                .build();
        userRespository.save(user);
    }

    @Override
    public Optional<User> findByEmail(String email) {
        return userRespository.findByEmail(email);
    }
}
