package com.authentication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.authentication.models.LoginUser;
import com.authentication.models.Project;
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
        return "redirect:/dashboard";
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
        return "redirect:/dashboard";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) { 
            session.invalidate();
            return "redirect:/";

    }
    
    
    @GetMapping("/dashboard")
    public String dashboard(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
        Long user_id = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id);
        model.addAttribute("thisUser", thisUser);
        
        List<Project> contains = userServ.userContains(thisUser);
        model.addAttribute("project", contains);
        
        List<Project> notContains = userServ.notContains(thisUser);
        model.addAttribute("projects", notContains);
        return "home.jsp";
    }
        else {
            return "redirect:/";
        }
    }
    
    @GetMapping("/projects/{id}")
    public String show(@PathVariable("id") Long id, HttpSession session, Model model) {
    	model.addAttribute("project", userServ.findProjectById(id));
    	Long user_id = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id);
        model.addAttribute("thisUser", thisUser);
        
        return "show.jsp";
    }
    
    @DeleteMapping("/projects/{id}")
    public String delete(@PathVariable("id") Long id) {
    	userServ.deleteProject(id);
    	return "redirect:/dashboard";
    }
    
    @GetMapping("/projects/new")
    public String create(@ModelAttribute("createProject") Project project1) {
    	return "create.jsp";
    }
    
    @PostMapping("/create")
    public String createProject(@Valid @ModelAttribute("createProject") Project project1, BindingResult result, HttpSession session ) {
    	if(result.hasErrors()) {    
            return "create.jsp";
        }
    	else {
    		userServ.createProject(project1);
    		Long user_id = (Long) session.getAttribute("user_id");
            User thisUser = userServ.findUserById(user_id);
            
            List<Project> myProjects = thisUser.getProjects();
            myProjects.add(project1);
            thisUser.setProjects(myProjects);
            
//            List<User> user1 = project1.getUsers();
//            user1.add(thisUser);
//            project1.setUsers(user1);
//            
//            project1.getUsers().add(thisUser);
                      
            project1.setUserCreate(thisUser);
            userServ.updateProject(project1);
            return "redirect:/dashboard";
    		
    	}
    }
    
    @GetMapping("/join/{id}")
    public String join(@PathVariable("id") Long id, HttpSession session) {
    	Project project = userServ.findProjectById(id);
    	Long user_id = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id);
        
//        thisUser.getProjects().add(project);
        
        project.getUsers().add(thisUser);
        userServ.updateProject(project);
        
        return "redirect:/dashboard";
    }
    
    @GetMapping("/leave/{id}")
    public String leave(@PathVariable("id") Long id, HttpSession session) {
    	Project project = userServ.findProjectById(id);
    	Long user_id = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id);
        
//        thisUser.getProjects().add(project);
        
        project.getUsers().remove(thisUser);
        userServ.updateProject(project);
        
        return "redirect:/dashboard";
    }
    
    @GetMapping("/projects/edit/{id}")
    public String edit(@PathVariable("id") Long id, HttpSession session, Model model) {
    	model.addAttribute("editProject", userServ.findProjectById(id));
    	return "edit.jsp";
    	
    }
    
    @PutMapping("/projects/edit/{id}")
    public String editProject(@Valid @ModelAttribute("editProject") Project project1,@PathVariable("id")Long id,BindingResult result,HttpSession session) {
    	if(result.hasErrors()) {    
            return "edit.jsp";
        }
    	else {
    		userServ.createProject(project1);
    		Long user_id = (Long) session.getAttribute("user_id");
            User thisUser = userServ.findUserById(user_id);
            List<Project> myProjects = thisUser.getProjects();
            myProjects.add(project1);
            thisUser.setProjects(myProjects);
            project1.setUserCreate(thisUser);
            userServ.updateProject(project1);
            return "redirect:/dashboard";
    		
    	}
    }


}



