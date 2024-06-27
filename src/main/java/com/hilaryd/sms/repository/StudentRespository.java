package com.hilaryd.sms.repository;

import com.hilaryd.sms.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRespository extends JpaRepository<Student, Long> {
}
