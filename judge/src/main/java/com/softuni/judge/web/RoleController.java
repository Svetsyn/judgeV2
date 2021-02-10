package com.softuni.judge.web;

import com.softuni.judge.service.UserSevice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/roles")
public class RoleController {

    private final UserSevice userSevice;

    public RoleController(UserSevice userSevice) {
        this.userSevice = userSevice;
    }

    @GetMapping("/add")
    public String add(Model model){
        model.addAttribute("names",userSevice.findAllUsernames());
        return "role-add";
    }
}
