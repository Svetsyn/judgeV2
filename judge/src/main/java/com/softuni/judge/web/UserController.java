package com.softuni.judge.web;

import com.softuni.judge.model.binding.UserLoginBindingModel;
import com.softuni.judge.model.binding.UserRegisterBiningModel;
import com.softuni.judge.model.service.UserServiceModel;
import com.softuni.judge.service.UserSevice;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserSevice userSevice;
    private final ModelMapper modelMapper;

    public UserController(UserSevice userSevice, ModelMapper modelMapper) {
        this.userSevice = userSevice;
        this.modelMapper = modelMapper;
    }

    @GetMapping("/login")
    public String login(Model model) {

        if (!model.containsAttribute("userLoginBindingModel")) {
            model.addAttribute("userLoginBindingModel", new UserLoginBindingModel());
            model.addAttribute("notFound", false);
        }
        return "login";
    }

    @PostMapping("/login")
    public String loginConfirm(@Valid
                               @ModelAttribute UserLoginBindingModel userLoginBindingModel,
                               BindingResult bindingResult,
                               RedirectAttributes redirectAttributes,
                               HttpSession httpSession) {

        if (bindingResult.hasErrors()) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userLoginBindingModel", bindingResult);
            return "redirect:login";
        }
        UserServiceModel user = userSevice
                .findUserByUsernameAndPassword(userLoginBindingModel.getUsername(), userLoginBindingModel.getPassword());

        if (user == null) {
            redirectAttributes.addFlashAttribute("userLoginBindingModel", userLoginBindingModel);
            redirectAttributes.addFlashAttribute("notFound", true);
            return "redirect:login";
        }
        //httpSession.setAttribute("user",user);
        userSevice.login(user);

        return "redirect:/";
    }

    @GetMapping("/register")
    public String register(Model model) {
        if (!model.containsAttribute("userRedirectBindingModel")) {
            model.addAttribute("userRedirectBindingModel", new UserRegisterBiningModel());

        }
        return "register";
    }

    @PostMapping("/register")
    public String registerConfirm(@Valid
                                  @ModelAttribute UserRegisterBiningModel userRegisterBiningModel
            , BindingResult bindingResult
            , RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors() || !userRegisterBiningModel
        .getPassword().equals(userRegisterBiningModel.getConfirmPassword())) {
            redirectAttributes.addFlashAttribute("userRedirectBindingModel", userRegisterBiningModel);
            redirectAttributes.addFlashAttribute("org.springframework.validation.BindingResult.userRedirectBindingModel", bindingResult);
            return "redirect:register";
        }


        UserServiceModel userServiceModel = modelMapper
                .map(userRegisterBiningModel, UserServiceModel.class);

        userSevice.registerUser(userServiceModel);

        return "redirect:login";
    }

    @GetMapping("/logout")
    public String logout(){

        userSevice.logout();

        return "redirect:/";
    }
}
