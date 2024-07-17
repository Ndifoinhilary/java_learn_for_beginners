package com.hilaryd.blog.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "users")
@Table(name = "User", uniqueConstraints = {
        @UniqueConstraint(name = "user_email_unique", columnNames = "email")
})
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String userName;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;


    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles", joinColumns =
    @JoinColumn(name = "user_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "user_id_fk")),
            inverseJoinColumns = @JoinColumn(name = "role_id", referencedColumnName = "id",foreignKey = @ForeignKey(name = "roles_id_fk"))
    )
    private List<Role> roles = new ArrayList<>();
}
