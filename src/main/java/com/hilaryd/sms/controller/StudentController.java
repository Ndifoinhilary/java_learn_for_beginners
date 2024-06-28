package com.hilaryd.sms.controller;

import com.hilaryd.sms.dto.StudentDto;
import com.hilaryd.sms.services.StudentServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/students")
@RequiredArgsConstructor
public class StudentController {

    private final StudentServices studentServices;

//list the students
    @GetMapping("")
    public String listUsers(Model model){
        List<StudentDto> students = studentServices.getStudents();
        model.addAttribute("students", students);
        return "students";
    }

//    Created a student
    @GetMapping("/create-form")
    public  String addStudentForm(Model model){
        model.addAttribute("student", new StudentDto());
        return "create_form";
    }

    @PostMapping("/create")
    public  String createStudent(@Valid @ModelAttribute("student") StudentDto studentDto, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "create_form";
        }
        studentServices.createStudent(studentDto);
        return "redirect:/students?success";
    }


//    Edit a student

    @GetMapping("/{studentId}/edit")
    public String editStudent(@PathVariable("studentId") Long studentId, Model model){
        var student = studentServices.getStudentById(studentId);
        model.addAttribute("student", student);
        return "edit_student";
    }


    @PostMapping("/edit-form/{studentId}/edit")
    public  String edit(@PathVariable("studentId") Long studentId,@Valid @ModelAttribute("student") StudentDto studentDto , BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("student", studentDto);
            return "create_form";
        }
        studentServices.edited(studentDto, studentId);
        return "redirect:/students";
    }

//    delete a student

    @GetMapping("/{studentId}/delete")
    public String delete(@PathVariable("studentId") Long studentId){
        studentServices.delete(studentId);
        return "redirect:/students";
    }

//    view students

    @GetMapping("/{studentId}/view")
    public String view(@PathVariable("studentId") Long studentId, Model model){
        var student = studentServices.getStudentById(studentId);
        model.addAttribute("student", student);
        return "show_student";
    }
}
