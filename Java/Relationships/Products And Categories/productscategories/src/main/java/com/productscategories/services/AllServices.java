package com.productscategories.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.productscategories.models.Category;
import com.productscategories.models.Product;
import com.productscategories.repositories.CategoryRepository;
import com.productscategories.repositories.ProductRepository;

@Service
public class AllServices {
	private final ProductRepository productRepository;
	private final CategoryRepository categoryRepository;
	
	public AllServices(ProductRepository productRepository, CategoryRepository categoryRepository) {
		this.productRepository = productRepository;
		this.categoryRepository = categoryRepository;
	}
	
	public Product creatProduct(Product product) {
		return productRepository.save(product);
	}
	
	public Category creatCategory(Category category) {
		return categoryRepository.save(category);
	}
	
	public Product findProduct(Long id) {
		return this.productRepository.findById(id).orElse(null);
	}
	
	public Category findCategory(Long id) {
		return this.categoryRepository.findById(id).orElse(null);
	}
	
	public List<Product> allProducts(){
		return productRepository.findAll();
	}
	
	public List<Category> allCategories(){
		return categoryRepository.findAll();
	}
	
	public Product updateProduct(Product product) {
		return this.productRepository.save(product);
	}
	
	public Category updateCategory(Category category) {
		return this.categoryRepository.save(category);
	}
	
//	public Product updateProduct1(Long id,String name,String description,float price) {
//		
//	}
	
	
	public void deleteProduct(Long id) {
		Optional<Product> optionalProduct = productRepository.findById(id);
		if(optionalProduct.isPresent()) {
			productRepository.deleteById(id);
		}
		
	}
	
	public void deleteCategory(Long id) {
		Optional<Category> optionalCategory = categoryRepository.findById(id);
		if(optionalCategory.isPresent()) {
			productRepository.deleteById(id);
		}
		
	}
	

	
	public List<Product> productNotContain (Long id){
		Category category1 = findCategory(id);
		return productRepository.findByCategoriesNotContains(category1);
	}
	
	public List<Category> categoryNotContain (Long id){
		Product product1 = findProduct(id);
		return categoryRepository.findByProductsNotContains(product1);
		
	}


}
