package com.example.springboot.controllers;

import com.example.springboot.models.User;
import com.example.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public String findAll(Model model){
        model.addAttribute("users", userService.getAllUsers());
        return "users";
    }

    @GetMapping("/create")
    public String createUserForm(User user){
        return "create";
    }

    @PostMapping()
    public String createUser(User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @GetMapping("/update/{id}")
    public String updateUserForm(@PathVariable("id") Long id, Model model){
        User user = userService.getUserById(id);
        model.addAttribute("user", user);
        return "update";
    }

    @PatchMapping ("/update")
    public String updateUser(User user){
        userService.addUser(user);
        return "redirect:/";
    }

    @DeleteMapping ("/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userService.removeUser(id);
        return "redirect:/";
    }
}