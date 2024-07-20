package com.hilaryd.blog.services.impl;

import com.hilaryd.blog.dto.BlogPostDto;
import com.hilaryd.blog.entity.BlogPost;
import com.hilaryd.blog.entity.User;
import com.hilaryd.blog.repository.BlogPostRepository;
import com.hilaryd.blog.repository.UserRespository;
import com.hilaryd.blog.services.BlogPostServices;
import com.hilaryd.blog.util.SecurityUtils;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlogPostImpl implements BlogPostServices {
    private final BlogPostRepository blogPostRepository;
    private final UserRespository userRespository;
    private final ModelMapper modelMapper;

    @Override
    public List<BlogPostDto> listAllPost() {
        List<BlogPost> posts = blogPostRepository.findAll();
        return posts.stream().map(post -> modelMapper.map(post, BlogPostDto.class)).collect(Collectors.toList());
    }

    @Override
    public void createBlogPost(BlogPostDto postDto) {
        String email = Objects.requireNonNull(SecurityUtils.getCurrentUser()).getUsername();
        User user = userRespository.findByEmail(email).get();
        var post = modelMapper.map(postDto, BlogPost.class);
        post.setCreatedBy(user);
        blogPostRepository.save(post);
    }

    @Override
    public BlogPostDto findPostById(Long postId) {
        Optional<BlogPost> post = blogPostRepository.findById(postId);
        return modelMapper.map(post, BlogPostDto.class);

    }

    @Override
    public void updatePost(BlogPostDto postDto, Long postId) {
        BlogPost post = blogPostRepository.findById(postId).get();
        String email = Objects.requireNonNull(SecurityUtils.getCurrentUser()).getUsername();
        User user = userRespository.findByEmail(email).get();
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setUpdatedOn(postDto.getUpdatedOn());
        post.setCreatedBy(user);
        blogPostRepository.save(post);
    }

    @Override
    public void delete(Long postId) {
        BlogPost post = blogPostRepository.findById(postId).get();
        blogPostRepository.delete(post);
    }

    @Override
    public BlogPostDto findPostByUrl(String postUrl) {
        BlogPost post = blogPostRepository.findByUrl(postUrl);
        return modelMapper.map(post, BlogPostDto.class);
    }

    @Override
    public List<BlogPostDto> searchedBlogPost(String query) {
        List<BlogPost> posts = blogPostRepository.searchPost(query);
        return posts.stream().map(post -> modelMapper.map(post, BlogPostDto.class)).collect(Collectors.toList());
    }

    @Override
    public List<BlogPostDto> findAllBlogPostForUser() {
        String email = Objects.requireNonNull(SecurityUtils.getCurrentUser()).getUsername();
        User user  = userRespository.findByEmail(email).get();
        Long userId = user.getId();
        List<BlogPost> posts = blogPostRepository.findBlogPostByUse(userId);

        return  posts.stream().map(post -> modelMapper.map(post, BlogPostDto.class)).collect(Collectors.toList());
    }
}