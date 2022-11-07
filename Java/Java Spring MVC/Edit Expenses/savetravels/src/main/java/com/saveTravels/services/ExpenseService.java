package com.saveTravels.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.saveTravels.models.Expense;
import com.saveTravels.repositories.ExpenseRepository;
@Service
public class ExpenseService {
	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}
	
	public List<Expense> allExpenses(){
		return expenseRepository.findAll();
	}
	
	public Expense creatExpense(Expense expense) {
		return expenseRepository.save(expense);
	}
	
	public Expense findExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			return optionalExpense.get();
		}
		else {
			return null;
		}
	}
	
	public Expense updateExpense(Expense expense) {
		Optional <Expense>optionalExpense=expenseRepository.findById(expense.getId());
		if(optionalExpense.isPresent()) {
			Expense a=optionalExpense.get();
			a=expense;
			return expenseRepository.save(a);}
		
		else {
			return null;
		}
			
	}
	
	public void deleteExpense(Long id) {
		Optional<Expense> optionalExpense = expenseRepository.findById(id);
		if(optionalExpense.isPresent()) {
			expenseRepository.deleteById(id);
		}
	}

}
