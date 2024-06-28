package com.hilaryd.sms.services;

import com.hilaryd.sms.dto.StudentDto;
import com.hilaryd.sms.entity.Student;

import java.util.List;

public interface StudentServices {

    List<StudentDto> getStudents();

    void createStudent(StudentDto studentDto);

    StudentDto getStudentById(Long studentId);

    void edited(StudentDto studentDto, Long studentId);

    void delete(Long studentId);
}
