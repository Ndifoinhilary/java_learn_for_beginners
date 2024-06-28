package com.hilaryd.sms.services;

import com.hilaryd.sms.dto.StudentDto;

import java.util.List;

public interface StudentServices {

    List<StudentDto> getStudents();

    void createStudent(StudentDto studentDto);
}
