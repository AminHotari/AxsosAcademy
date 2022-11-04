package com.OmikujiForm;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class omikuji {
	@GetMapping("/")
	public String index() {
		return "index.jsp";		
	}
	
	@PostMapping("/omikuji")
	public String send(@RequestParam(value="number") String number, @RequestParam(value="city") String city, @RequestParam(value="person") String person,
			@RequestParam(value="hobby") String hobby, @RequestParam(value="living") String living, @RequestParam(value="comment") String comment, HttpSession session) {
		session.setAttribute("number", number);
		session.setAttribute("city", city);
		session.setAttribute("person", person);
		session.setAttribute("hobby", hobby);
		session.setAttribute("living", living);
		session.setAttribute("comment", comment);
		
		return "redirect:/show";		
	}
	
	@GetMapping("/show")
	public String show() {
		return "show.jsp";
	}
	
	
	

}
