package com.hilaryd.blog.repository;

import com.hilaryd.blog.entity.BlogPostComment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BlogPostCommentRepository extends JpaRepository<BlogPostComment, Long> {
}
