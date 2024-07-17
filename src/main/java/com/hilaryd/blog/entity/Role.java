package com.hilaryd.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;


@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = 'roles')
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    private List<User> userList = new ArrayList<>();
}
