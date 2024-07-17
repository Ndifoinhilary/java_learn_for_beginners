package com.hilaryd.blog.controller;

import com.hilaryd.blog.dto.BlogPostCommentDto;
import com.hilaryd.blog.services.BlogPostCommentServices;
import com.hilaryd.blog.services.BlogPostServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BlogCommentController {
    private final BlogPostCommentServices postCommentServices;

    private final BlogPostServices postServices;


    @PostMapping("/create/comment/{postUrl}")
    public String createComment(@PathVariable("postUrl") String postUrl, @Valid @ModelAttribute("comment")
    BlogPostCommentDto bLogPostCommentDto, BindingResult result, Model model) {

        var post = postServices.findPostByUrl(postUrl);

        if (result.hasErrors()){
            model.addAttribute("comment", bLogPostCommentDto);
            model.addAttribute("post", post);
            return "blog/detail_post";
        }

        postCommentServices.createComment(postUrl, bLogPostCommentDto);
        return STR."redirect:/post/\{postUrl}";
    }
}
