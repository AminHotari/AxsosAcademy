package com.saveTravels.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

}
