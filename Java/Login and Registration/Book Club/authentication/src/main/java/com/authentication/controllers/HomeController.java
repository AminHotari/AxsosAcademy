package com.authentication.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.authentication.models.Book;
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
        return "redirect:/books";
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
        return "redirect:/books";
    }
    
    @GetMapping("/logout")
    public String logout(HttpSession session) { 
            session.invalidate();
            return "redirect:/";

    }
    
    
    @GetMapping("/books")
    public String home(Model model, HttpSession session) {
        if (session.getAttribute("user_id") != null) {
        Long user_id1 = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id1);
        model.addAttribute("thisUser1", thisUser);
        
        model.addAttribute("books", userServ.allBooks());
        return "home.jsp";
    }
        else {
            return "redirect:/";
        }
    }
    
    @GetMapping("/books/new")
    public String addBook(@ModelAttribute("addBook") Book book1,Model model,HttpSession session) {   	
    	return "newBook.jsp";
    }
    
    @PostMapping("/addBook")
    public String create(@Valid @ModelAttribute("addBook") Book book1,BindingResult result,HttpSession session) {
    	if(result.hasErrors()) {    
            return "newBook.jsp";
        }
    	else {
    		userServ.creatBook(book1);
    		Long user_id1 = (Long) session.getAttribute("user_id");
    		User thisUser1 = userServ.findUserById(user_id1);
    		List<Book> books = thisUser1.getBooks();
    		book1.setUser(thisUser1);
    		userServ.updateBook(book1);
    		return "redirect:/books";   		
    	}
    }
    
    @GetMapping("/books/{id}")
    public String show(@PathVariable("id")Long id,Model model,HttpSession session) {
    	model.addAttribute("book", userServ.findBook(id));
    	Long user_id1 = (Long) session.getAttribute("user_id");
        User thisUser = userServ.findUserById(user_id1);
        model.addAttribute("thisUser1", thisUser);
    	
    	return "show.jsp";
    }
    
    @GetMapping("/delete/{id}")
    public String deleteBook(@PathVariable("id")Long id,Model model,HttpSession session) {
    	userServ.deleteBook(id);
    	return "redirect:/books";
    }
    
    @GetMapping("/books/{id}/edit")
    public String editBook(@PathVariable("id")Long id,Model model,HttpSession session) {
    	model.addAttribute("editBook", userServ.findBook(id));
    	return "edit.jsp";
    }
    
    @PutMapping("/editBook/{id}")
    public String edit(@Valid @ModelAttribute("editBook") Book book1,BindingResult result, @PathVariable("id")Long id,Model model,HttpSession session) {
    	if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			userServ.updateBook(book1);
			Long user_id1 = (Long) session.getAttribute("user_id");
			User thisUser = userServ.findUserById(user_id1);
			List<Book> books = thisUser.getBooks();
			book1.setUser(thisUser);
    		userServ.updateBook(book1);
			return "redirect:/books";
		}
    }
    	


}



