package com.hilaryd.blog.services.impl;

import com.hilaryd.blog.dto.BlogPostCommentDto;
import com.hilaryd.blog.entity.BlogPost;
import com.hilaryd.blog.entity.BlogPostComment;
import com.hilaryd.blog.repository.BlogPostCommentRepository;
import com.hilaryd.blog.repository.BlogPostRepository;
import com.hilaryd.blog.services.BlogPostCommentServices;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogPostCommentServiceImpl implements BlogPostCommentServices {

    private final BlogPostCommentRepository commentRepository;

    private final BlogPostRepository blogPostRepository;
    private final ModelMapper modelMapper;

    @Override
    public void createComment(String postUrl, BlogPostCommentDto postCommentDto) {

        BlogPost post = blogPostRepository.findByUrl(postUrl);

        BlogPostComment postComment = modelMapper.map(postCommentDto, BlogPostComment.class);

        postComment.setBlogPost(post);

        commentRepository.save(postComment);




    }
}
