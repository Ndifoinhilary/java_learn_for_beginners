package com.hilaryd.blog.repository;

import com.hilaryd.blog.entity.BlogPost;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface BlogPostRepository extends JpaRepository<BlogPost, Long> {

    Optional<BlogPost> findByUrl(String url);


    @Query("SELECT p from BlogPost p WHERE "
            + " p.title LIKE CONCAT('%', :query, '%') OR "
            + "p.description LIKE CONCAT('%', :query, '%') ")
    List<BlogPost> searchPost(String query);
}
