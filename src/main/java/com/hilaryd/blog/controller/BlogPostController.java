package com.hilaryd.blog.controller;


import com.hilaryd.blog.dto.BlogPostDto;
import com.hilaryd.blog.services.BlogPostServices;
import com.hilaryd.blog.util.ROLES;
import com.hilaryd.blog.util.SecurityUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class BlogPostController {


    private final BlogPostServices postServices;

//    the list of all post from the db

    private static String getUrl(String postTitle) {
        String title = postTitle.trim().toLowerCase();
        String url = title.replaceAll("\\s", "-");
        url = url.replaceAll("[^A-Za-z0-9]", "-");
        return url;
    }

//    Create a blog Post

    @GetMapping("/admin/posts")
    public String showPost(Model model) {
        List<BlogPostDto> posts = null;

        String role = SecurityUtils.getRoles();

        if (ROLES.ROLE_ADMIN.name().equals(role)) {
            posts = postServices.listAllPost();
        } else {
            posts = postServices.findAllBlogPostForUser();
        }

        model.addAttribute("posts", posts);
        return "/admin/post";
    }

    @GetMapping("/create-post/form")
    public String showCreatePostForm(Model model) {
        BlogPostDto blogPostDto = new BlogPostDto();
        model.addAttribute("posts", blogPostDto);
        return "/admin/create_post";
    }

    @PostMapping("/admin/create")
    public String createPost(@Valid @ModelAttribute("posts") BlogPostDto blogPostDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("posts", blogPostDto);
            return "/admin/create_post";
        }
        blogPostDto.setUrl(getUrl(blogPostDto.getTitle()));
        postServices.createBlogPost(blogPostDto);
        return "redirect:/admin/posts";

    }

//    blog post update feature

    @GetMapping("/admin/update/{postId}/post")
    public String updateForm(@PathVariable("postId") Long postId, Model model) {
        var post = postServices.findPostById(postId);
        model.addAttribute("post", post);
        return "/admin/update";
    }

    @PostMapping("/admin/post/{postId}/update")
    public String updatePost(@PathVariable("postId") Long postId, @Valid @ModelAttribute("post") BlogPostDto blogPostDto, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("post", blogPostDto);
            return "/admin/update";
        }
        blogPostDto.setUrl(getUrl(blogPostDto.getTitle()));
        postServices.updatePost(blogPostDto, postId);
        return "redirect:/admin/posts";
    }


//    delete a post by Id


    @GetMapping("/admin/delete/{postId}/post")
    public String deletePost(@PathVariable("postId") Long postId) {
        postServices.delete(postId);
        return "redirect:/admin/posts";
    }

//    view blog post

    @GetMapping("/admin/view/{postId}/view")
    public String viewPost(@PathVariable("postId") Long postId, Model model) {
        var post = postServices.findPostById(postId);
        model.addAttribute("post", post);
        return "admin/view_post";
    }

//    performing searching operation

    @GetMapping("/admin/posts/search")
    public String searchPost(@RequestParam(value = "query") String query, Model model) {
        List<BlogPostDto> postDtos = postServices.searchedBlogPost(query);
        model.addAttribute("posts", postDtos);

        return "/admin/post";
    }
}
