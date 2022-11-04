package com.mvc.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.models.Book;
import com.mvc.service.BookService;

@Controller
public class BookController {
	private final BookService bookService;

	public BookController(BookService bookService) {
		this.bookService = bookService;
	}
	
	@RequestMapping("/")
	public String welcome(){
		return "welcom.jsp";
	}
	
	
	
	@RequestMapping("/books")
	public String books(Model model){
		List<Book> books = bookService.allBooks();
		model.addAttribute("books1", books);
		return "books.jsp";
	}
	
	@RequestMapping("/books/{id}")
	public String bookId(Model model, @PathVariable("id") Long id){
		Book book = bookService.findBook(id);
		model.addAttribute("book", book);
		return "show.jsp";
	}
	
	

}
