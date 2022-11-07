package com.saveTravels.controllers;

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

import com.saveTravels.models.Expense;
import com.saveTravels.services.ExpenseService;


@Controller
public class ExpenseController {
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/")
	public String index() {
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String expenses(@ModelAttribute("expense") Expense expense, Model model) {
		List<Expense> expenses = expenseService.allExpenses();
		model.addAttribute("expenses1", expenses);
		return "index.jsp";
	}
	
	@PostMapping("/expenses")
	public String submit(@Valid @ModelAttribute("expense") Expense expense, BindingResult result,Model model) {
		if(result.hasErrors()) {
			List<Expense> expenses = expenseService.allExpenses();
			model.addAttribute("expenses1", expenses);			
			return "index.jsp";
		}
		else {
			expenseService.creatExpense(expense);
			return "redirect:/expenses";
		}
		
	}
	
	@GetMapping("/expenses/edit/{id}")
	public String edit(@PathVariable("id") Long id,@ModelAttribute("expense") Expense expense,Model model) {
		Expense expense1 = expenseService.findExpense(id);
		model.addAttribute("expenseEdit", expense1);
		return "edit.jsp";
	}
	
	@PutMapping("/expenses/{id}")
	public String update(@Valid @ModelAttribute("expense") Expense expense,BindingResult result,@PathVariable("id") Long id) {
		if(result.hasErrors()) {
			return "edit.jsp";
		}
		else {
			expenseService.updateExpense(expense);
			return "redirect:/expenses";
		}
	}
	
	@DeleteMapping("/expenses/{id}")
	public String destroy(@PathVariable("id")Long id) {
		expenseService.deleteExpense(id);
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses/{id}")
	public String details(@PathVariable("id")Long id,@ModelAttribute("expense") Expense expense,Model model) {
		Expense expense2 = expenseService.findExpense(id);
		model.addAttribute("details", expense2);
		return "details.jsp";
	}

}
