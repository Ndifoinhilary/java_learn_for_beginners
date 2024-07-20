package com.hilaryd.blog.controller;


import com.hilaryd.blog.dto.BlogPostCommentDto;
import com.hilaryd.blog.dto.BlogPostDto;
import com.hilaryd.blog.services.BlogPostServices;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class ClientController {
    private final BlogPostServices postServices;


    @GetMapping("/")
    public String clientPostView(Model model){
        List<BlogPostDto> posts = postServices.listAllPost();
        model.addAttribute("posts", posts);
        return "blog/view_post";
    }

//    show a given blog post

    @GetMapping("/post/{postUrl}")
    public String detailBlogPot(@PathVariable("postUrl") String postUrl, Model model){
        var post =  postServices.findPostByUrl(postUrl);
        model.addAttribute("post", post);

        BlogPostCommentDto comments = new BlogPostCommentDto();
        model.addAttribute("comment", comments);
        return "blog/detail_post";
    }

//    search a blog post for a client


    @GetMapping("/post/searcher")
    public String showSearchedResult(@RequestParam(value = "query") String query, Model model){
        List<BlogPostDto> postDos = postServices.searchedBlogPost(query);
        model.addAttribute("posts", postDos);
        return "blog/view_post";
    }
}
