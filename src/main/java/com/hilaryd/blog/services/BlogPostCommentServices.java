package com.hilaryd.blog.services;

import com.hilaryd.blog.dto.BlogPostCommentDto;

public interface BlogPostCommentServices {

    void createComment(String postUrl,  BlogPostCommentDto postCommentDto);
}
