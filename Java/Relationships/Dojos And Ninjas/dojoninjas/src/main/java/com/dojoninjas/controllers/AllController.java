package com.dojoninjas.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dojoninjas.models.Dojo;
import com.dojoninjas.models.Ninja;
import com.dojoninjas.services.AllServices;

@Controller
public class AllController {
	private final AllServices allServices;

	public AllController(AllServices allServices) {
		this.allServices = allServices;
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/dojos/new";
	}
	
	@GetMapping("/dojos/new")
	public String dojo(@ModelAttribute("dojo") Dojo dojo1) {
		return "dojo.jsp";
	}
	
	@PostMapping("/dojos")
	public String newDojo(@Valid @ModelAttribute("dojo") Dojo dojo1,BindingResult result) {
		if(result.hasErrors()) {		
			return "dojo.jsp";
		}
		else {
			allServices.creatDojo(dojo1);
			return "redirect:/dojos/new";
		}
		
	}
	
	@GetMapping("/ninjas/new")
	public String ninja(@ModelAttribute("ninja") Ninja ninja1,Model model) {
		model.addAttribute("dojos", allServices.allDojos());
		return "ninja.jsp";
	}
	
	@PostMapping("/ninjas")
	public String newNinja(@Valid @ModelAttribute("ninja") Ninja ninja1,BindingResult result,Model model) {
		if(result.hasErrors()) {
			model.addAttribute("dojos", allServices.allDojos());
			return "nina.jsp";
		}
		else {
			allServices.creatNinja(ninja1);
			return "redirect:/ninjas/new";
		}
		
	}
	
	@GetMapping("/dojos/{id}")
	public String ninja(@PathVariable("id")Long id,Model model) {
		model.addAttribute("dojo", allServices.findDojo(id));
		return "show.jsp";
	}

}
