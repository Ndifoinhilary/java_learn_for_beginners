package com.hilaryd.blog.dto;

import com.hilaryd.blog.entity.Role;
import lombok.*;

import java.util.List;


@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private Long id;

    private String userName;

    private String email;

    private String password;


}
