package com.hilaryd.sms.services.impl;

import com.hilaryd.sms.dto.StudentDto;
import com.hilaryd.sms.entity.Student;
import com.hilaryd.sms.repository.StudentRespository;
import com.hilaryd.sms.services.StudentServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class StudentServicesImpl implements StudentServices {

    private final StudentRespository studentRespository;

    private final ModelMapper modelMapper;


    @Override
    public List<StudentDto> getStudents() {

        List<Student> allStudents = studentRespository.findAll();

        return allStudents.stream().map(student -> modelMapper.map(student, StudentDto.class)).collect(Collectors.toList());
    }

    @Override
    public void createStudent(StudentDto studentDto) {
        var student = modelMapper.map(studentDto, Student.class);
        studentRespository.save(student);

    }
}
