package com.Counter;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Counter {
	@RequestMapping("/")
	public String index(HttpSession session) {
		if(session.getAttribute("count") == null) {
			session.setAttribute("count", 0);
		}
		else {
			Integer counter = (Integer) session.getAttribute("count");
			counter ++;
			session.setAttribute("count", counter);
		}
		
		return "index.jsp";
	}
	
	@RequestMapping("/counter")
	public String count(HttpSession session, Model model) {
		
		model.addAttribute("number",session.getAttribute("count"));
		return "count.jsp";
	}

}
