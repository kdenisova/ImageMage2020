package com.imagemage.web.application;

import com.imagemage.web.infrastructure.security.UserEntity;
import com.imagemage.web.infrastructure.security.UserService;
import com.imagemage.web.infrastructure.security.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("user")
    public UserEntity userEntity() {
        return new UserEntity();
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/signup")
    public String signUp() {
        return "signup";
    }

    @PostMapping("/signup")
    public String signUp(@ModelAttribute("user") UserEntity userEntity, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Vaidation error");
            return "/signup";
        }

        userService.save(userEntity);

        return "redirect:/login";
    }
}
