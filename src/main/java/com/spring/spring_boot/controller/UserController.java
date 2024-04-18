package com.spring.spring_boot.controller;

import com.spring.spring_boot.dao.UserRepository;
import com.spring.spring_boot.model.User;
import com.spring.spring_boot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class UserController {
    private UserService userRepository;

    @Autowired
    public UserController(UserService userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping("/")
    public String getUser(Model model) {
        model.addAttribute("users", userRepository.getAllUsers());
        return "user/users";
    }

    @PostMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
        userRepository.saveUser(user);
        return "redirect:/";
    }

    @GetMapping("/addUser")
    public String addUser(Model model) {
        model.addAttribute("user", new User());
        return "/user/addUser";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute("user") User user) {
        userRepository.saveUser(user);
        return "redirect:/";
    }


    @GetMapping("/editUser")
    public String editUser(Model model, @RequestParam("id") int id) {
        User user = userRepository.getUser(id);
        model.addAttribute("user", user);
        return "/user/updateUser";
    }

    @PostMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") int id) {
        userRepository.deleteUser(id);
        return "redirect:/";
    }


    @GetMapping("/deleteUser")
    public String deleteUser(Model model, @RequestParam("id") int id) {
        User user = userRepository.getUser(id);
        model.addAttribute("user", user);
        return "/user/deleteUser";
    }

}