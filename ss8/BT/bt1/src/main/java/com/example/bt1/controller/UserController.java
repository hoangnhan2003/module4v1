package com.example.bt1.controller;

import com.example.bt1.model.User;
import com.example.bt1.service.IUserService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
@RequestMapping("user")
public class UserController {
    @Autowired
    IUserService userService;
    @GetMapping("")
    public String showUserList(@PageableDefault(value = 4)Pageable pageable, Model model){
        Page<User> userPage = userService.findAll(pageable);
        model.addAttribute("userList",userPage);
        return "user_list";
    }
    @GetMapping("/create")
    public String showCreateForm(Model model){
        model.addAttribute("user",new User());
        return "create_user";
    }
    @PostMapping("/create")
    public String addUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult
            , Model model, RedirectAttributes redirectAttributes){
        if (bindingResult.hasErrors()){
            return "create_user";
        }
        redirectAttributes.addFlashAttribute("msg","Add user successful");
        userService.save(user);
        return "redirect:/user";

    }
}
