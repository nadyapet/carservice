package com.company.carservices.controller;

import com.company.carservices.dto.UserDto;
import com.company.carservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/sign-up")
    public String signUpForm(Model model)
    {
        model.addAttribute("user", new UserDto());
        return "/users/sign-up";
    }

    @PostMapping("/sign-up")
    public String signUp(@ModelAttribute("user") UserDto userDto) {
        userService.saveUser(userDto);
        return "redirect:/login";
    }
}
