package com.codeup.springblogv2.controllers;

import com.codeup.springblogv2.models.Post;
import com.codeup.springblogv2.models.User;
import com.codeup.springblogv2.repos.PostRepository;
import com.codeup.springblogv2.repos.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class PostController {

    PostRepository postRepository;
    UserRepository userRepository;

    public PostController(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/posts")
    public String viewPosts(Model model) {
        model.addAttribute("postList", postRepository.findAll());
//        GETTING THE USERNAME BY USING THE USER REPO
        String user = userRepository.findById(1L).get().getName();
        model.addAttribute("name", user);
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    @ResponseBody
    public String singlePost(@PathVariable long id) {
        return "Viewing post with the id of: " + id;
    }


    //    ****** View form for creating a post (MODEL BIDING) *******
    @GetMapping("/posts/create-form")
    public String createPostsForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create-post-form";
    }


    @PostMapping("/posts/create")
    public String createNewPost(@RequestParam String title, @RequestParam String body) {
        User user = userRepository.getById(1L);
        Post newPost = new Post(title, body);
        newPost.setUser(user);

//        SAVING THE CREATED POST TO POSTS REPO
        postRepository.save(newPost);
//        REDIRECTING TO VIEW ALL POSTS PAGE
        return "redirect:/posts";
    }
}