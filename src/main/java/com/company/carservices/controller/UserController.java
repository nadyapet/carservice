package com.company.carservices.controller;

import com.company.carservices.dto.UserDto;
import com.company.carservices.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value="/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value="/sign-up")
    public @ResponseBody
    Integer signUp(@RequestBody UserDto userDto) {
        return userService.saveUser(userDto);
    }
}
