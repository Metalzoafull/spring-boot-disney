package com.example.disney.controller;

import com.example.disney.model.User;
import com.example.disney.service.api.UserServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Controller
public class UserController {

    @Autowired
    private UserServiceAPI userServiceAPI;

    BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(4);


    @GetMapping({"/","/auth/login"})
    public String index(){
        return "auth/login";
    }


    @GetMapping("/auth/register")
    public String showsave(Model model) {
        model.addAttribute("user",new User());
        return "auth/register";
    }


    @PostMapping("/auth/register")
    public String save(@Validated User user, Model model){
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        userServiceAPI.save(user);
        return "redirect:/auth/login";

    }

    @GetMapping("/home")
    public String home(){
        return "/home";
    }

    @GetMapping("/hola")
    public String hola() {
        return "hola";
    }
}
