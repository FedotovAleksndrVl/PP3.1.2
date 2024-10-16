package ru.kata.spring.boot_security.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;
import java.security.Principal;

@Controller
public class UserController {

    final private UserServiceImpl userService;

    @Autowired
    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/user")
    public String user(Model model, Principal principal) {
        model.addAttribute("users", userService.getUserByLogin(principal.getName()));
        return "user";
    }
}
