package com.authentication.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.authentication.models.LoginUser;
import com.authentication.models.User;
import com.authentication.services.UserService;



    
@Controller
public class HomeController {
    
    @Autowired
    private UserService userServ;
    
    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("newUser", new User());
        model.addAttribute("newLogin", new LoginUser());
        return "loginRegistration.jsp";
    }
    
    @PostMapping("/register")
    public String register(@Valid @ModelAttribute("newUser") User newUser1, 
            BindingResult result, Model model, HttpSession session) {
        userServ.register(newUser1, result);
        if(result.hasErrors()) {
            model.addAttribute("newLogin", new LoginUser());
            return "loginRegistration.jsp";
        }
        session.setAttribute("user_id", newUser1.getId());
        return "redirect:/home";
    }
    
    @PostMapping("/login")
    public String login(@Valid @ModelAttribute("newLogin") LoginUser newLogin1, 
            BindingResult result, Model model, HttpSession session) {
        User user = userServ.login(newLogin1, result);
        if(result.hasErrors()) {
            model.addAttribute("newUser", new User());
            return "loginRegistration.jsp";
        }
        session.setAttribute("user_id", user.getId());
        return "redirect:/home";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) { 
            session.invalidate();
            return "redirect:/";

    }
    
    
    @GetMapping("/home")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
        Long user_id = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id);
        model.addAttribute("thisUser", thisUser);
        return "home.jsp";
    }
        else {
            return "redirect:/";
        }
    }


}



