package com.hilaryd.sms.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class StudentDto {
        private Long id;
        @NotEmpty(message = "Student must have first name please")
        private String firstName;

        @NotEmpty(message = "Student must have last name please")
        private String lastName;

        @NotEmpty(message = "Student must have an email please")
        @Email
        private String email;


}
