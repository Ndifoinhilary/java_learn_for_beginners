package com.hilaryd.blog.services;

import com.hilaryd.blog.dto.BlogPostDto;

import java.util.List;

public interface BlogPostServices {

    List<BlogPostDto> listAllPost();

    void createBlogPost(BlogPostDto postDto);
}
