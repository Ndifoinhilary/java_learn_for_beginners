package com.hilaryd.blog.controller;


import com.hilaryd.blog.dto.BlogPostDto;
import com.hilaryd.blog.services.BlogPostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/post")
@RequiredArgsConstructor
public class BlogPostController {


    private final BlogPostServices postServices;

//    the list of all post from the db

    @GetMapping("")
    public String showPost(Model model){
        List<BlogPostDto> posts = postServices.listAllPost();
        model.addAttribute("posts", posts);
        return "/admin/post";
    }

//    Create a blog Post

    @GetMapping("/create-form")
    public String showCreatePostForm(Model model){
        BlogPostDto blogPostDto = new  BlogPostDto();
       model.addAttribute("posts", blogPostDto);
       return "/admin/create_post";
    }
}
