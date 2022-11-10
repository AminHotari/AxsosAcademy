package com.languages.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.languages.models.Language;
import com.languages.services.LanguagesService;

@Controller
public class LanguageConroller {
	
	private final LanguagesService languagesService;
	
	public LanguageConroller(LanguagesService languagesService) {
		this.languagesService = languagesService;
	}
	
	@GetMapping("/")
	public String index() {
		return "redirect:/languages";
	}
	
	@GetMapping("/languages")
	public String home(@ModelAttribute("language") Language language,Model model) {
		List<Language> languages = languagesService.allLanguage();
		model.addAttribute("language1", languages);
		return "home.jsp";
	}
	 @PostMapping("/languages")
	 public String submit(@Valid @ModelAttribute("language") Language language,BindingResult result,Model model) {
		 if(result.hasErrors()) {			 
			 List<Language> languages = languagesService.allLanguage();
			 model.addAttribute("language1", languages);
			 return "home.jsp";			
		 }
		 else {
			 languagesService.creatLanguage(language);
			 return "redirect:/languages";
		 }
	 }
	
	@DeleteMapping("/languages/{id}")
	public String destroy(@PathVariable("id")Long id) {
		languagesService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	@GetMapping("/languages/edit/{id}")
	public String edit(@PathVariable("id") Long id,@ModelAttribute("language") Language language,Model model) {
		Language language1 = languagesService.findLanguage(id);
		model.addAttribute("languageEdit", language1);
		return "edit.jsp";
		
	}
	
	@PutMapping("/languages/{id}")
	public String update(@Valid @ModelAttribute("language") Language language1,BindingResult result,@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			languagesService.updateLanguage(language1);
			return "redirect:/languages";
		}
	}
	
	@GetMapping("languages/{id}")
	public String show(@PathVariable("id") Long id,Model model) {
		Language language1 = languagesService.findLanguage(id);
		model.addAttribute("show", language1);
		return "show.jsp";
	}

}
