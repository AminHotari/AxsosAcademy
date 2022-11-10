package com.productscategories.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.productscategories.models.Category;
import com.productscategories.models.Product;
import com.productscategories.services.AllServices;

@Controller
public class AllController {
	private final AllServices allServices;

	public AllController(AllServices allServices) {
		this.allServices = allServices;
	}
	
	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("products", allServices.allProducts());
		model.addAttribute("categories", allServices.allCategories());
		return "home.jsp";
	}
	
	@GetMapping("/products/new")
	public String newProduct(@ModelAttribute("product") Product product1) {
		return "newProduct.jsp";
	}
	
	@PostMapping("/products")
	public String newProduct(@Valid @ModelAttribute("product") Product product1,BindingResult result) {
		if(result.hasErrors()) {		
			return "newProduct.jsp";
		}
		else {
			allServices.creatProduct(product1);
			return "redirect:/";
		}
		
	}
	
	
	
	@GetMapping("/categories/new")
	public String newC(@ModelAttribute("category") Category category1) {
		return "newCategory.jsp";
	}
	
	@PostMapping("/categories")
	public String newC(@Valid @ModelAttribute("category") Category category1,BindingResult result) {
		if(result.hasErrors()) {		
			return "newCategory.jsp";
		}
		else {
			allServices.creatCategory(category1);
			return "redirect:/";
		}
		
	}
	
	@GetMapping("/products/{id}")
	public String aProduct(@PathVariable("id")Long id,Model model) {
		model.addAttribute("product", allServices.findProduct(id));
		model.addAttribute("categories", allServices.categoryNotContain(id));
		return "showProduct.jsp";
	}
	
	@PostMapping("/addCategory/{id}")
	public String add(@PathVariable("id")Long id,@RequestParam(value="categoryId") Long id1,Model model) {
		Product product1 = allServices.findProduct(id);
		Category category1 = allServices.findCategory(id1);
		List<Category> list = product1.getCategories();
		list.add(category1);
		product1.setCategories(list);
		allServices.updateProduct(product1);
		return "redirect:/products/{id}";
	}
	
	@GetMapping("/categories/{id}")
	public String aCategory(@PathVariable("id")Long id,Model model) {
		model.addAttribute("category", allServices.findCategory(id));
		model.addAttribute("products", allServices.productNotContain(id));
		return "showCategory.jsp";
	}
	
	@PostMapping("/addProduct/{id}")
	public String add1(@PathVariable("id")Long id,@RequestParam(value="productId") Long id1,Model model) {
		Product product1 = allServices.findProduct(id);
		Category category1 = allServices.findCategory(id1);
		List<Product> list = category1.getProducts();
		list.add(product1);
		category1.setProducts(list);
		allServices.updateCategory(category1);
		return "redirect:/categories/{id}";
	}
}
