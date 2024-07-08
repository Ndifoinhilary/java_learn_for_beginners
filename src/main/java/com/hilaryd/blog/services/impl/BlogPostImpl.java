package com.hilaryd.blog.services.impl;

import com.hilaryd.blog.dto.BlogPostDto;
import com.hilaryd.blog.entity.BlogPost;
import com.hilaryd.blog.repository.BlogPostRepository;
import com.hilaryd.blog.services.BlogPostServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogPostImpl implements BlogPostServices {
    private final BlogPostRepository blogPostRepository;

    private final ModelMapper modelMapper;

    @Override
    public List<BlogPostDto> listAllPost() {
        List<BlogPost> posts = blogPostRepository.findAll();
        return posts.stream().map(post -> modelMapper.map(post, BlogPostDto.class)).collect(Collectors.toList());
    }

    @Override
    public void createBlogPost(BlogPostDto postDto) {
        var blogPostDto = modelMapper.map(postDto, BlogPost.class);
        blogPostRepository.save(blogPostDto);
    }
}