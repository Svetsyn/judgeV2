package com.softuni.judge.web;

import com.softuni.judge.model.binding.UserRegisterBiningModel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRedirectBindingModel")){
            model.addAttribute("userRedirectBindingModel", new UserRegisterBiningModel());
        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid
                                  @ModelAttribute UserRegisterBiningModel userRegisterBiningModel
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userRedirectBindingModel",userRegisterBiningModel);
            return "redirect:register";
        }

        //ToDo save user in DB

        return "redirect:login";
    }
}
