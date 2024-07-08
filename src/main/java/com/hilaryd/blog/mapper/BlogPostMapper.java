package com.hilaryd.blog.mapper;

import com.hilaryd.blog.dto.BlogPostDto;
import com.hilaryd.blog.entity.BlogPost;

public class BlogPostMapper {

    public static BlogPostDto mapToDto(BlogPost blogPost){
        return BlogPostDto.builder()
                .id(blogPost.getId())
                .title(blogPost.getTitle())
                .url(blogPost.getUrl())
                .content(blogPost.getContent())
                .description(blogPost.getDescription())
                .createdOn(blogPost.getCreatedOn())
                .updatedOn(blogPost.getUpdatedOn())
                .build();

    }

    public static BlogPost mapToPost(BlogPostDto blogPostDto){
        return  BlogPost.builder()
                .id(blogPostDto.getId())
                .title(blogPostDto.getTitle())
                .url(blogPostDto.getUrl())
                .content(blogPostDto.getContent())
                .description(blogPostDto.getDescription())
                .createdOn(blogPostDto.getCreatedOn())
                .updatedOn(blogPostDto.getUpdatedOn())
                .build();
    }
}
