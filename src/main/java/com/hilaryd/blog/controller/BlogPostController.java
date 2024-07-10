package com.hilaryd.blog.controller;


import com.hilaryd.blog.dto.BlogPostDto;
import com.hilaryd.blog.services.BlogPostServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogPostController {


    private final BlogPostServices postServices;

//    the list of all post from the db

    @GetMapping("/admin/posts")
    public String showPost(Model model){
        List<BlogPostDto> posts = postServices.listAllPost();
        model.addAttribute("posts", posts);
        return "/admin/post";
    }

//    Create a blog Post

    @GetMapping("/create-post/form")
    public String showCreatePostForm(Model model){
        BlogPostDto blogPostDto = new  BlogPostDto();
       model.addAttribute("posts", blogPostDto);
       return "/admin/create_post";
    }

    @PostMapping("/admin/create")
    public String createPost(@Valid @ModelAttribute("posts") BlogPostDto blogPostDto, BindingResult result, Model model){
        if (result.hasErrors()){
            model.addAttribute("posts", blogPostDto);
            return "/admin/create_post";
        }
        blogPostDto.setUrl(getUrl(blogPostDto.getTitle()));
        postServices.createBlogPost(blogPostDto);
        return "redirect:/admin/posts";

    }

    private static String getUrl(String postTitle){
        String title = postTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
    }
}
