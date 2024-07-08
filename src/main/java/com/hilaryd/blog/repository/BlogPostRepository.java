package com.hilaryd.blog.repository;

import com.hilaryd.blog.entity.BlogPost;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BlogPostRepository  extends JpaRepository<BlogPost, Long> {

    Optional<BlogPost> findByUrl(String url);
}
