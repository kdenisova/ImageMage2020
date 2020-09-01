package com.imagemage.web.application;

import com.imagemage.web.infrastructure.security.UserForm;
import com.imagemage.web.infrastructure.security.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @ModelAttribute("userform")
    public UserForm userForm() {
        return new UserForm();
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
    public String signUp(@ModelAttribute("user") @Valid UserForm userForm, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Validation error");
            return "/signup";
        }

        userService.save(userForm.toUserEntity());

        return "redirect:/login";
    }
}
