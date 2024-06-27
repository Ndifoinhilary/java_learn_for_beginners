package com.hilaryd.sms.controller;

import com.hilaryd.sms.dto.StudentDto;
import com.hilaryd.sms.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/users")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServices studentServices;


    public String listUsers(Model model){
        List<StudentDto> students = studentServices.getStudents();
        model.addAttribute("students", students);
        return "students";
    }
}
