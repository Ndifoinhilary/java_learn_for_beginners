package com.hilaryd.blog.controller;

import com.hilaryd.blog.dto.RegistrationDto;
import com.hilaryd.blog.dto.UserDto;
import com.hilaryd.blog.entity.User;
import com.hilaryd.blog.services.RegistrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class AuthController {

    private final RegistrationService registrationService;

//    handle the form display for the user to register

    @GetMapping("/register/form")
    public String showRegistrationForm(Model model) {
        RegistrationDto user = new RegistrationDto();
        model.addAttribute("user", user);
        return "blog/register";
    }

//    handle the user registration request view

    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("user") RegistrationDto registrationDto, Model model, BindingResult result) {
        Optional<User> existUser = registrationService.findByEmail(registrationDto.getEmail());
        if (existUser.isPresent()) {
            result.reject("email", null, "User with this email already exists");
        }
        if (result.hasErrors()) {
            model.addAttribute("user", registrationDto);
            return "blog/register";
        }

        registrationService.registerUser(registrationDto);

        return "redirect:blog/register?success";
    }
}
