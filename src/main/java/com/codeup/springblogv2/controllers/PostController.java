package com.codeup.springblogv2.controllers;

import com.codeup.springblogv2.models.Post;
import com.codeup.springblogv2.models.User;
import com.codeup.springblogv2.repos.PostRepository;
import com.codeup.springblogv2.repos.UserRepository;
import org.springframework.security.core.context.SecurityContextHolder;
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
        User logginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        System.out.println(logginUser.getUsername());
        System.out.println(logginUser.getId());
        System.out.println(logginUser.getEmail());
//        String user = userRepository.findById(1L).get().getUsername();
        model.addAttribute("username", logginUser.getUsername());
        return "posts/show";
    }

    @GetMapping("/posts-search")
    public String viewPostsSearch(Model model) {
        model.addAttribute("postListSearch", postRepository.findAll());
//        GETTING THE USERNAME BY USING THE USER REPO
        User logginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("username", logginUser.getUsername());
        return "posts/show";
    }

    @GetMapping("/posts/{id}")
    public String singlePost(@PathVariable long id, Model model) {
//        String userName = userRepository.findById(1L).get().getUsername();
        Post postId = postRepository.findById(id).get();
        User logginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        model.addAttribute("username", logginUser.getUsername());
        model.addAttribute("postId", postId);
        return "/posts/individual-post";
    }


    //    ****** View form for creating a post (MODEL BIDING) *******
    @GetMapping("/posts/create-form")
    public String createPostsForm(Model model) {
        model.addAttribute("post", new Post());
        return "posts/create-post-form";
    }


    @PostMapping("/posts/create")
    public String createNewPost(@RequestParam String title, @RequestParam String body) {
//        User user = userRepository.getById(1L);
        User logginUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Post newPost = new Post(title, body);
        newPost.setUser(logginUser);

//        SAVING THE CREATED POST TO POSTS REPO
        postRepository.save(newPost);
//        REDIRECTING TO VIEW ALL POSTS PAGE
        return "redirect:/posts";
    }


}