package com.hilaryd.blog.dto;

import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
public class BlogPostDto {
    private Long id;
    private String title;
    private String url;
    private String content;
    private String description;
    private LocalDateTime createdOn;
    private LocalDateTime updatedOn;
}
