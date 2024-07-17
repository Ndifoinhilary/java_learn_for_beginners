package com.hilaryd.blog.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.*;

import java.time.LocalDateTime;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class BlogPostCommentDto {

    private Long id;
    @NotEmpty(message = "Enter a content please")
    private String content;
    @Email
    @NotEmpty(message = "Enter a valid email please")
    private String email;
    @NotEmpty(message = "Just enter your  name please")
    private String userName;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;

}
